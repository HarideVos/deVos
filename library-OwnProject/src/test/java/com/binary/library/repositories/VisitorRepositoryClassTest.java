package com.binary.library.repositories;

import com.binary.library.entities.Visitor;
import com.binary.library.services.VisitorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VisitorRepositoryClassTest {

    @Mock
    private VisitorRepository visitorRepository;

    @InjectMocks
    private VisitorServiceImpl visitorService; // Assuming you have a VisitorService to interact with the repository

    @Test
    void testFindByEmail() {
        // Given
        String email = "john@example.com";
        Visitor expectedVisitor = new Visitor("John Doe", email, "password", "ROLE_USER");

        // When
        when(visitorRepository.findByEmail(email)).thenReturn(expectedVisitor);
        Visitor actualVisitor = visitorService.getVisitorByEmail(email);

        // Then
        assertEquals(expectedVisitor.getName(), actualVisitor.getName());
        assertEquals(expectedVisitor.getEmail(), actualVisitor.getEmail());
        assertEquals(expectedVisitor.getPassword(), actualVisitor.getPassword());
        assertEquals(expectedVisitor.getRole(), actualVisitor.getRole());
    }
}