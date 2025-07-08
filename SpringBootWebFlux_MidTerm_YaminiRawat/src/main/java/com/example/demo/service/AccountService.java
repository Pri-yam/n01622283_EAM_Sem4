package com.example.demo.service;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Checking;
import com.example.demo.entity.Savings;
import com.example.demo.repository.CheckingRepository;
import com.example.demo.repository.SavingsRepostiory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountService {

	@Autowired
    private CheckingRepository checkingRepo;
	
	@Autowired
    private SavingsRepostiory savingsRepo;

    public Mono<Checking> createChecking(Checking checking) {
        return checkingRepo.save(checking);
    }

    public Flux<Checking> getAllChecking() {
        return checkingRepo.findAll();
    }

    public Mono<Savings> createSavings(Savings savings) {
        return savingsRepo.save(savings);
    }

    public Flux<Savings> getAllSavings() {
        return savingsRepo.findAll();
    }
}