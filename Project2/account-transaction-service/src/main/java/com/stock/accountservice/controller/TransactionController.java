package com.stock.accountservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.accountservice.entity.AccountTransaction;
import com.stock.accountservice.repository.TransactionRepository;
import com.stock.accountservice.service.TransactionService;

@RestController
@RequestMapping("/account/transactions")
public class TransactionController {

    private final TransactionService service;
    private final TransactionRepository repository;

    public TransactionController(TransactionService service, TransactionRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<AccountTransaction> save(@RequestBody AccountTransaction tx) {
        return ResponseEntity.ok(service.recordTransaction(tx));
    }

    @GetMapping
    public ResponseEntity<List<AccountTransaction>> all() {
        return ResponseEntity.ok(service.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountTransaction> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getTransactionById(id));
    }

    // ✅ New endpoint for Market Service confirmation check
    @GetMapping("/existsByOrderId/{orderId}")
    public ResponseEntity<Boolean> existsByOrderId(@PathVariable int orderId) {
        boolean exists = repository.existsByOrderId(orderId);
        return ResponseEntity.ok(exists);
    }
}
