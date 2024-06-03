package com.binary.library.services;

import com.binary.library.entities.Visitor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public interface VisitorService {
    List<Visitor> getAllVisitors();
    Visitor createVisitor(Visitor visitor);
    Visitor updateVisitor(int id, Visitor updateVisitor);
    Visitor deleteVisitor(int id);
    Optional<Visitor> getVisitorById(int id);
    Visitor getVisitorByEmail(String email);


}
