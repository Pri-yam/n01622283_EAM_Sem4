package com.stock.orderservice.controller;

import com.stock.orderservice.entity.Order;
import com.stock.orderservice.service.OrderService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
    private OrderService orderService;
	
	
	//create new order
	@PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order, @RequestParam double pricePerUnit) {
        // For plain order creation, could use buyOrder logic (business-specific)
        // Assumes order fields are set in JSON
        Order saved = orderService.buyOrder(order, order.getQuantity(), pricePerUnit);
        return ResponseEntity.ok(saved);
    }

	//sell an order
	@PostMapping("/sell/{id}")
    public ResponseEntity<Order> sellOrder(
            @PathVariable int id,
            @RequestParam double price) {

        Order updated = orderService.sellOrder(id, price);
        return ResponseEntity.ok(updated);
    }
	
	//get order by id
	@GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }
	
	//get all orders
	@GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
	
	
	@PostMapping("/buy/{id}")
	public ResponseEntity<Order> buy(@PathVariable int id,
	                                 @RequestParam int quantity,
	                                 @RequestParam double price) {
	    Order order = orderService.getOrderById(id);
	    return ResponseEntity.ok(orderService.buyOrder(order, quantity, price));
	}

	@PostMapping("/sell/{id}")
	public ResponseEntity<Order> sell(@PathVariable int id,
	                                  @RequestParam double price) {
	    return ResponseEntity.ok(orderService.sellOrder(id, price));
	}
}
