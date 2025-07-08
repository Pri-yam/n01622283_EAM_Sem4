package com.example.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.example.demo.entity.Checking;

public interface CheckingRepository extends ReactiveMongoRepository<Checking, String> {
}