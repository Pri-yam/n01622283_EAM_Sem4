package com.example.demo.service;

import com.example.demo.Entity.Member;
import com.example.demo.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class MemberService {

	@Autowired
    private MemberRepository repo;

    public Flux<Member> getAll() {
        return repo.findAll();
    }

    public Mono<Member> getById(String id) {
        return repo.findById(id);
    }

    public Mono<Member> save(Member member) {
        return repo.save(member);
    }

    public Mono<Member> update(String id, Member member) {
        member.setMembId(id);
        return repo.save(member);
    }

    public Mono<Void> delete(String id) {
        return repo.deleteById(id);
    }
    
}
