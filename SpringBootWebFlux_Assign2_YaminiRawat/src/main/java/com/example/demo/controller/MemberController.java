package com.example.demo.controller;

import com.example.demo.Entity.Member;
import com.example.demo.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {

	@Autowired
    private MemberService service;

    @GetMapping
    public Flux<Member> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Mono<Member> getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public Mono<Member> save(@RequestBody Member member) {
        return service.save(member);
    }

    @PutMapping("{id}")
    public Mono<Member> update(@PathVariable String id, @RequestBody Member member) {
        return service.update(id, member);
    }

    @DeleteMapping("{id}")
    public Mono<String> delete(@PathVariable String id) {
        return service.delete(id).thenReturn("Deleted member with ID: " + id);
    }
}
