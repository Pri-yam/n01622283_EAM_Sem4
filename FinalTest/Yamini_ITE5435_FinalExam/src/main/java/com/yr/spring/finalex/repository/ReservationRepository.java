package com.yr.spring.finalex.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.yr.spring.finalex.model.Reservation;

public interface ReservationRepository extends MongoRepository<Reservation, String> {}
