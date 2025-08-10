package com.stock.accountservice.service;

import com.stock.accountservice.entity.AccountTransaction;
import com.stock.accountservice.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public AccountTransaction recordTransaction(AccountTransaction transaction) {
        return repository.save(transaction);
    }

    public List<AccountTransaction> getAllTransactions() {
        return repository.findAll();
    }

    public AccountTransaction getTransactionById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found: " + id));
    }

    public boolean existsByOrderId(int orderId) {
        return repository.existsByOrderId(orderId);
    }
}

