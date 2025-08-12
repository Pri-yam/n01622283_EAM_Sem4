package com.yr.spring.finalex.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.yr.spring.finalex.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	Optional<Customer> findByEmail(String email);
}
