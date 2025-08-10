package com.stock.accountservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stock.accountservice.entity.AccountTransaction;

public interface TransactionRepository extends MongoRepository<AccountTransaction, Integer> {
	
	boolean existsByOrderId(int orderId);
}