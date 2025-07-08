package com.example.demo.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "checking")
public class Checking extends Account {
    private double insufficientFundFee;

    public void processCheck(double amount) {
        if (getBalance() < amount) {
            setBalance(getBalance() - insufficientFundFee);
        } else {
            withdrawal(amount);
        }
    }
}