package com.binary.banking.repository;

import com.binary.banking.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> { public Optional<Member> findByEmail(String Email);}

