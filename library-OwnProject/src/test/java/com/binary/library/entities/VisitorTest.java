package com.binary.library.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VisitorTest {

    @Test
    void testNoArgsConstructor() {
        Visitor visitor = new Visitor("James", "james@email.com", "12345678", "ROLE_ADMIN");
        assertNull(null, visitor.getName());
        assertNull(null, visitor.getEmail());
        assertNull(null, visitor.getPassword());
        assertNull(null, visitor.getRole());
    }

    @Test
    void testAllArgsConstructor() {
        String name = "Test Name";
        String email = "test@example.com";
        String password = "password123";
        String role = "ROLE_USER";

        Visitor visitor = new Visitor(name, email, password, role);

        assertEquals(name, visitor.getName());
        assertEquals(email, visitor.getEmail());
        assertEquals(password, visitor.getPassword());
        assertEquals(role, visitor.getRole());
    }

    @Test
    void testSettersAndGetters() {
        Visitor visitor = new Visitor("James", "james@email.com", "12345678", "admin");

        int id = 1;
        String name = "Test Name";
        String email = "test@example.com";
        String password = "password123";
        String role = "ROLE_USER";

        visitor.setId(id);
        visitor.setName(name);
        visitor.setEmail(email);
        visitor.setPassword(password);
        visitor.setRole(role);

        assertEquals(id, visitor.getId());
        assertEquals(name, visitor.getName());
        assertEquals(email, visitor.getEmail());
        assertEquals(password, visitor.getPassword());
        assertEquals(role, visitor.getRole());
    }
}
