package com.stock.accountservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class AccountTransaction {
    @Id
    private int transactionId;

    private int orderId;
    private String TransactionType;
    private String tickerSymbol;
    private double transactionPrice;
    private String orderDateTime;
    private double orderAmt;
    private double balanceAmt;

    // Getters, Setters, and Constructors
    // plus methods: ConfirmBuyTransaction(), ConfirmSellTransaction()
}
