package com.example.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.demo.entity.Savings;

public interface SavingsRepostiory extends ReactiveMongoRepository<Savings, String> {
}