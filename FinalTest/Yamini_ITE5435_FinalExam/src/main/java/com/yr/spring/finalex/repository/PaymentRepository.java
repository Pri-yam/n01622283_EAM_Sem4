package com.yr.spring.finalex.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.yr.spring.finalex.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {}
