package com.example.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.example.demo.Entity.Publisher;

public interface PublisherRepository extends ReactiveMongoRepository<Publisher, String> {
}