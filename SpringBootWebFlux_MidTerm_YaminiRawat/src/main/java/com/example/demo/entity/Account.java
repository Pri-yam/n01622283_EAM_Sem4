package com.example.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Account {
    @Id
    private String id;
    private String accountHolder;
    private double balance;

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdrawal(double amount) {
        this.balance -= amount;
    }

    public void updateBalance(double newBalance) {
        this.balance = newBalance;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}