package com.stock.marketservice.controller;

import com.stock.marketservice.entity.MarketOrder;
import com.stock.marketservice.service.MarketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {

    private final MarketService service;

    public MarketController(MarketService service) {
        this.service = service;
    }

    @PostMapping("/orders")
    public ResponseEntity<MarketOrder> processOrder(@RequestBody MarketOrder order) {
        return ResponseEntity.ok(service.processMarketOrder(order));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<MarketOrder>> getAll() {
        return ResponseEntity.ok(service.getAllMarketOrders());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<MarketOrder> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getMarketOrderById(id));
    }
    
    @PostMapping("/orders/{id}/confirm")
    public ResponseEntity<MarketOrder> confirmOrder(@PathVariable int id) {
        return ResponseEntity.ok(service.orderTransactionConfirmation(id));
    }
}
