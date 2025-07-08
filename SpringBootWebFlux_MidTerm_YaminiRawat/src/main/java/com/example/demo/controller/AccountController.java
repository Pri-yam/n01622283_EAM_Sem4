package com.example.demo.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Checking;
import com.example.demo.entity.Savings;
import com.example.demo.service.AccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

	@Autowired
    private AccountService accountService;

    @PostMapping("/checking")
    public Mono<Checking> addChecking(@RequestBody Checking checking) {
        return accountService.createChecking(checking);
    }

    @GetMapping("/checking")
    public Flux<Checking> getAllChecking() {
        return accountService.getAllChecking();
    }

    @PostMapping("/savings")
    public Mono<Savings> addSavings(@RequestBody Savings savings) {
        return accountService.createSavings(savings);
    }

    @GetMapping("/savings")
    public Flux<Savings> getAllSavings() {
        return accountService.getAllSavings();
    }
}