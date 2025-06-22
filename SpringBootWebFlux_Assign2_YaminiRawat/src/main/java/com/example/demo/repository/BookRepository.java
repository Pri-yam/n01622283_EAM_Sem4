package com.example.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.demo.Entity.Book;

import reactor.core.publisher.Flux;

public interface BookRepository extends ReactiveMongoRepository<Book, Long>{

}
