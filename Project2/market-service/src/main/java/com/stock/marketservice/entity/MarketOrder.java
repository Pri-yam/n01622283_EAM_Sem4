package com.stock.marketservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "marketOrders")
public class MarketOrder {
    @Id
    private int orderId;

    private int transactionId;
    private int feeId;
    private double bid;
    private double ask;
    private double previous;
    private double last;
    private String typeOfExchange_NYSE_TSE_Montreal;
    private String confirmationStatus;
    
	public void setConfirmationStatus(String string) {
		// TODO Auto-generated method stub
		
	}

	public Object getOrderId() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLast() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getStockSymbol() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

    // plus method: OrderTransactionConfirmation()
}
