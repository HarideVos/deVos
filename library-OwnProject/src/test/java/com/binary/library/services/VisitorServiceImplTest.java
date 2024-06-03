package com.binary.library.services;

import com.binary.library.entities.Visitor;
import com.binary.library.repositories.VisitorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class VisitorServiceImplTest {

    @Mock
    private VisitorRepository visitorRepository;

    @InjectMocks
    private VisitorServiceImpl visitorService;

    @BeforeEach
    void setUp() {
        visitorService = new VisitorServiceImpl();
    }

    @Test
    void testGetAllVisitors() {
        // Mock data
        List<Visitor> mockVisitors = List.of(new Visitor("John Doe", "john@example.com", "password", "ROLE_USER"),
                new Visitor("Jane Doe", "jane@example.com", "password", "ROLE_ADMIN"));
        when(visitorRepository.findAll()).thenReturn(mockVisitors);

        // Test
        List<Visitor> allVisitors = visitorService.getAllVisitors();

        assertEquals(mockVisitors.size(), allVisitors.size());
    }

    @Test
    void testCreateVisitor() {
        // Mock data
        Visitor mockVisitor = new Visitor("John Doe", "john@example.com", "password", "ROLE_USER");
        when(visitorRepository.save(mockVisitor)).thenReturn(mockVisitor);

        // Test
        Visitor createdVisitor = visitorService.createVisitor(mockVisitor);

        assertNotNull(createdVisitor);
        assertEquals(mockVisitor.getName(), createdVisitor.getName());
        assertEquals(mockVisitor.getEmail(), createdVisitor.getEmail());
        assertEquals(mockVisitor.getPassword(), createdVisitor.getPassword());
        assertEquals(mockVisitor.getRole(), createdVisitor.getRole());
    }

    @Test
    void testUpdateVisitor() {
        // Mock data
        int visitorId = 1;
        Visitor existingVisitor = new Visitor("John Doe", "john@example.com", "password", "ROLE_USER");
        Visitor updatedVisitor = new Visitor("Updated Name", "updated@example.com", "updatedPassword", "ROLE_ADMIN");
        when(visitorRepository.findById(visitorId)).thenReturn(Optional.of(existingVisitor));
        when(visitorRepository.save(updatedVisitor)).thenReturn(updatedVisitor);

        // Test
        Visitor updatedResult = visitorService.updateVisitor(visitorId, updatedVisitor);

        assertNotNull(updatedResult);
        assertEquals(updatedVisitor.getName(), updatedResult.getName());
        assertEquals(updatedVisitor.getEmail(), updatedResult.getEmail());
        assertEquals(updatedVisitor.getPassword(), updatedResult.getPassword());
        assertEquals(updatedVisitor.getRole(), updatedResult.getRole());
    }

    @Test
    void testDeleteVisitor() {
        // Mock data
        int visitorId = 1;
        Visitor existingVisitor = new Visitor("John Doe", "john@example.com", "password", "ROLE_USER");
        when(visitorRepository.findById(visitorId)).thenReturn(Optional.of(existingVisitor));

        // Test
        Visitor deletedVisitor = visitorService.deleteVisitor(visitorId);

        assertNotNull(deletedVisitor);
        assertEquals(existingVisitor, deletedVisitor);
        verify(visitorRepository, times(1)).deleteById(visitorId);
    }

    @Test
    void testGetVisitorById() {
        // Mock data
        int visitorId = 1;
        Visitor mockVisitor = new Visitor("John Doe", "john@example.com", "password", "ROLE_USER");
        when(visitorRepository.findById(visitorId)).thenReturn(Optional.of(mockVisitor));

        // Test
        Optional<Visitor> retrievedVisitorOptional = visitorService.getVisitorById(visitorId);
        Visitor retrievedVisitor = retrievedVisitorOptional.orElse(null);

        assertNotNull(retrievedVisitor);
        assertEquals(mockVisitor, retrievedVisitor);
    }

    @Test
    void testGetVisitorByEmail() {
        // Mock data
        String email = "john@example.com";
        Visitor mockVisitor = new Visitor("John Doe", email, "password", "ROLE_USER");
        when(visitorRepository.findByEmail(email)).thenReturn(mockVisitor);

        // Test
        Visitor retrievedVisitor = visitorService.getVisitorByEmail(email);

        assertNotNull(retrievedVisitor);
        assertEquals(mockVisitor, retrievedVisitor);
    }
}