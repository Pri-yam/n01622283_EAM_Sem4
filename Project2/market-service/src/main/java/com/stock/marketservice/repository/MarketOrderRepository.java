package com.stock.marketservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.stock.marketservice.entity.MarketOrder;

public interface MarketOrderRepository extends MongoRepository<MarketOrder, Integer> {
	
}