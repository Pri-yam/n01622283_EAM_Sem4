package com.example.yamini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yamini.entity.Publisher;
import com.example.yamini.repository.PublisherRepository;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

	@Autowired
    private PublisherRepository publisherRepo;

    @PostMapping
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherRepo.findAll();
    }

    @GetMapping("/{id}")
    public Publisher getPublisherById(@PathVariable Long id) {
        return publisherRepo.findById(id).orElse(null);
    }
}
