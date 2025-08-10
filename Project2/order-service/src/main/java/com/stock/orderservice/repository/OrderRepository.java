package com.stock.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.stock.orderservice.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> { }
