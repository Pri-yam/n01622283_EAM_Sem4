package com.example.demo.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Publisher;
import com.example.demo.repository.PublisherRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class PublisherService {

	@Autowired
    private PublisherRepository repo;

    public Flux<Publisher> getAll() {
        return repo.findAll();
    }

    public Mono<Publisher> getById(String id) {
        return repo.findById(id);
    }

    public Mono<Publisher> save(Publisher publisher) {
        return repo.save(publisher);
    }

    public Mono<Publisher> update(String id, Publisher publisher) {
        publisher.setPubId(id);
        return repo.save(publisher);
    }

    public Mono<Void> delete(String id) {
        return repo.deleteById(id);
    }
}
