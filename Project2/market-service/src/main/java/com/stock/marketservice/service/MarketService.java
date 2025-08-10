package com.stock.marketservice.service;

import com.stock.marketservice.entity.MarketOrder;
import com.stock.marketservice.repository.MarketOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MarketService {

    private final MarketOrderRepository repository;
    private final RestTemplate restTemplate;

    public MarketService(MarketOrderRepository repository) {
        this.repository = repository;
        this.restTemplate = new RestTemplate();
    }

    /**
     * Process an order and notify Account Transaction Service.
     */
    public MarketOrder processMarketOrder(MarketOrder order) 
    {
        order.setConfirmationStatus("PENDING");
        MarketOrder savedOrder = repository.save(order);

        try {
            restTemplate.postForObject(
                "http://ACCOUNT-SERVICE/account/transactions",
                MarketToTransactionMapper.map(savedOrder),
                Void.class
            );
        } catch (Exception e) {
            System.err.println("Error notifying ACCOUNT-SERVICE: " + e.getMessage());
            savedOrder.setConfirmationStatus("FAILED_TO_SEND");
            repository.save(savedOrder);
        }

        return savedOrder;
    }
    
    /**
     * Confirm whether the transaction for a market order exists in Account Transaction Service.
     */
    public MarketOrder orderTransactionConfirmation(int orderId) {
        MarketOrder marketOrder = repository.findById(orderId)
            .orElseThrow(() -> new IllegalArgumentException("Market order not found: " + orderId));

        try {
            Boolean exists = restTemplate.getForObject(
                "http://ACCOUNT-SERVICE/account/transactions/existsByOrderId/" + orderId,
                Boolean.class
            );

            if (Boolean.TRUE.equals(exists)) {
                marketOrder.setConfirmationStatus("CONFIRMED");
            } else {
                marketOrder.setConfirmationStatus("NOT_FOUND");
            }
        } catch (Exception e) {
            marketOrder.setConfirmationStatus("CONFIRMATION_FAILED");
            System.err.println("Error confirming transaction: " + e.getMessage());
        }

        return repository.save(marketOrder);
    }


    public List<MarketOrder> getAllMarketOrders() {
        return repository.findAll();
    }

    public MarketOrder getMarketOrderById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Market order not found: " + id));
    }
}
