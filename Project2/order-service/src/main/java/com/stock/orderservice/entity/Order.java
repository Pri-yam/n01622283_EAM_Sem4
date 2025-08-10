package com.stock.orderservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {
    @Id
    private int orderId;

    private int quantity;
    private String tickerSymbol;
    private double orderAmt;
    private boolean AddMoreAsRequired;
    private String OrderDate;
    private int FeeId;
    private String attribute;
    private String orderType_BuyOrSell; // Consider enum
	public void setOrderType_BuyOrSell(String string) {
		// TODO Auto-generated method stub
		
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(double orderAmt) {
		this.orderAmt = orderAmt;
	}

    
}