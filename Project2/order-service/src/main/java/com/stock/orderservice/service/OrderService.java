package com.stock.orderservice.service;

import com.stock.orderservice.entity.Order;
import com.stock.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.restTemplate = new RestTemplate(); // For inter-service calls
    }

    //get all orders
    public java.util.List<Order> getAllOrders() 
    {
        return orderRepository.findAll();
    }
    
    //get oder by id
    public Order getOrderById(int orderId) 
    {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderId));
    }
    
    //Buy an order
    public Order buyOrder(Order order, 
    						int quantityToBuy, 
    						double pricePerUnit) 
    {
        order.setQuantity(order.getQuantity() + quantityToBuy);
        order.setOrderType_BuyOrSell("BUY");
        order.setOrderAmt(order.getQuantity() * pricePerUnit);

        Order savedOrder = orderRepository.save(order);

        // Send this order to MARKET-SERVICE via Eureka (dynamic JSON URL)
        try {
            restTemplate.postForObject(
                "http://market-service/market/orders",  // Service name resolved by Eureka
                savedOrder,
                Void.class
            );
        } catch (Exception e) {
            System.err.println("Could not notify MARKET-SERVICE: " + e.getMessage());
        }

        return savedOrder;
    }
    
    //Sell Order
    public Order sellOrder(int orderId, 
    						double pricePerUnit) 
    {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderId));

        if (order.getQuantity() <= 0) {
            throw new IllegalStateException("No quantity available to sell for order: " + orderId);
        }

        order.setOrderType_BuyOrSell("SELL");
        order.setOrderAmt(order.getQuantity() * pricePerUnit);
        order.setQuantity(0);

        return orderRepository.save(order);
    }
}
