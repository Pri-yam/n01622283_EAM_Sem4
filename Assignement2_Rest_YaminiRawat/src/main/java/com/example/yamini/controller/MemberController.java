package com.example.yamini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yamini.entity.Member;
import com.example.yamini.repository.MemberRepository;

@RestController
@RequestMapping("/members")
public class MemberController {
	
	@Autowired
    private MemberRepository memberRepo;

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberRepo.save(member);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberRepo.findById(id).orElse(null);
    }
}
