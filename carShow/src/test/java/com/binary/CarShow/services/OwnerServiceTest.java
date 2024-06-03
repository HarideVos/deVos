package com.binary.CarShow.services;

import com.binary.CarShow.entities.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OwnerServiceTest {

    @Autowired
    private OwnerService ownerService;

    @Test
    void createOwner() {
        Owner owner = new Owner();
        owner.setFirstName("John ");
        owner.setLastName("Doe");

        Owner createdOwner = ownerService.createOwner(owner);

        assertNotNull(createdOwner);
        assertNotNull(createdOwner.getOwnerId());
    }
}