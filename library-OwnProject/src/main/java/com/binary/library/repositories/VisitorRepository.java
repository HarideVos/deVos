package com.binary.library.repositories;

import com.binary.library.entities.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Integer> {
    public Visitor findByEmail(String email);
}
