package com.example.yamini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.yamini.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
