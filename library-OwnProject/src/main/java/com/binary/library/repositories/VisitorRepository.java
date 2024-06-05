package com.binary.library.repositories;

import com.binary.library.entities.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer> {
    public Visitor findByEmail(String email);
}
