package com.binary.library.config;

import com.binary.library.entities.Visitor;
import com.binary.library.services.VisitorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VisitorDetailsServiceTest {

    @Mock
    private VisitorService visitorService;

    @InjectMocks
    private VisitorDetailsService visitorDetailsService;

    @Test
    public void testLoadUserByUsername_Success() {
        MockitoAnnotations.openMocks(this);

        String username = "test@example.com";
        String password = "password";
        String role = "ROLE_USER";

        Visitor visitor = new Visitor("John", "john@email.com", "12345678", "ROLE_ADMIN");
        visitor.setEmail(username);
        visitor.setPassword(password);
        visitor.setRole(role);

        when(visitorService.getVisitorByEmail(username)).thenReturn(visitor);

        UserDetails userDetails = visitorDetailsService.loadUserByUsername(username);

        assertEquals(username, userDetails.getUsername());
        assertEquals(password, userDetails.getPassword());
        assertEquals(1, userDetails.getAuthorities().size());
        assertTrue(userDetails.getAuthorities().contains(new SimpleGrantedAuthority(role)));
    }

    @Test
    public void testLoadUserByUsername_VisitorNotFound() {
        MockitoAnnotations.openMocks(this);

        String username = "test@example.com";

        when(visitorService.getVisitorByEmail(username)).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
            visitorDetailsService.loadUserByUsername(username);
        });
    }
}
