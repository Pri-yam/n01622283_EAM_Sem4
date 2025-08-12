package com.yr.spring.finalex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Document(collection = "payments")
public class Payment {

    @Id
    private String id;

    @NotNull(message = "Amount is required")
    private Double amount;

    @NotBlank(message = "Payment method is required")
    private String method; // Credit, Debit, PayPal

    private LocalDate paymentDate;

    // Link to Reservation
    private String reservationId;
}
