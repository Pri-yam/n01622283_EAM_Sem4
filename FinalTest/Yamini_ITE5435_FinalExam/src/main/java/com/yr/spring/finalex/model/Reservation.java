package com.yr.spring.finalex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Document(collection = "reservations")
public class Reservation {
    @Id
    private String id;

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    //this customerId points to a doc in customers collection
    private String customerId;
    
    private int numPassengers;
    private String classType;
    private String phoneNumber;
    private String departTime;
    private String departDate;
}
