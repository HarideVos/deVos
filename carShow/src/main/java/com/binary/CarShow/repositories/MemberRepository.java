package com.binary.CarShow.repositories;

import com.binary.CarShow.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    public Member findByEmail(String email);
}
