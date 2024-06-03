package com.binary.library.services;

import com.binary.library.entities.Visitor;
import com.binary.library.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;

    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public Visitor updateVisitor(int id, Visitor updateVisitor) {
        Optional<Visitor> visitor = visitorRepository.findById(id);
        if (visitor.isEmpty()) {
            return visitorRepository.save(updateVisitor);
        } else {
            return null;
        }
    }

    @Override
    public Visitor deleteVisitor(int id) {
        return null;
    }

    @Override
    public Optional<Visitor> getVisitorById(int id) {
        Optional<Visitor> visitor = visitorRepository.findById(id);
        if (visitor.isEmpty()) {
            return visitorRepository.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public Visitor getVisitorByEmail(String email) {
        Visitor visitor = visitorRepository.findByEmail(email);
        if (visitor != null) {
            return visitorRepository.findByEmail(email);
        } else {
            return null;
        }
    }
}
