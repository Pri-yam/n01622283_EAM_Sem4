package com.example.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.demo.Entity.Member;

public interface MemberRepository extends ReactiveMongoRepository<Member, String> {

}
