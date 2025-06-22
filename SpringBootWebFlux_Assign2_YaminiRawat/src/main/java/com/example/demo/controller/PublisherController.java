package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.Publisher;
import com.example.demo.service.BookService;
import com.example.demo.service.PublisherService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/publisher")
@AllArgsConstructor
@RestController
public class PublisherController {
	
	@Autowired
    private PublisherService service;

    @GetMapping
    public Flux<Publisher> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Mono<Publisher> getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public Mono<Publisher> save(@RequestBody Publisher publisher) {
        return service.save(publisher);
    }

    @PutMapping("{id}")
    public Mono<Publisher> update(@PathVariable String id, @RequestBody Publisher publisher) {
        return service.update(id, publisher);
    }

    @DeleteMapping("{id}")
    public Mono<String> delete(@PathVariable String id) {
        return service.delete(id).thenReturn("Deleted publisher with ID: " + id);
    }

}
