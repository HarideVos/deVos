package com.library.library.repositories;


import com.library.library.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    public Member findByEmail(String email);
}
