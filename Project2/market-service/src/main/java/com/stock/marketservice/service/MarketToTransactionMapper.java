package com.stock.marketservice.service;

import com.stock.marketservice.entity.MarketOrder;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class MarketToTransactionMapper {

    public static Map<String, Object> map(MarketOrder mo) {
        Map<String, Object> tx = new HashMap<>();
        tx.put("orderId", (mo.getOrderId()));
        tx.put("userId", mo.getUserId());
        tx.put("stockSymbol", mo.getStockSymbol());
        tx.put("type", "COMMIT");
        tx.put("amount", mo.getQuantity() * mo.getLast());
        tx.put("datetime", LocalDateTime.now().toString());
        return tx;
    }
}