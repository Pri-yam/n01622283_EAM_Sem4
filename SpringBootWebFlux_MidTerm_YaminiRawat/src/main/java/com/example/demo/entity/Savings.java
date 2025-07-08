package com.example.demo.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "savings")
public class Savings extends Account {
    private double interestRate;

    public void depositMonthlyInterest() {
        deposit(getBalance() * interestRate / 100);
    }
}