package com.binary.shop.config;

import com.binary.shop.config.ClientDetailsService;
import com.binary.shop.entities.Client;
import com.binary.shop.services.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClientDetailsServiceTest {

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientDetailsService clientDetailsService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoadUserByUsername_ClientFound() {
        String username = "test@example.com";
        String password = "password";
        String role = "ROLE_USER";

        Client client = new Client(username, password, role);
        when(clientService.getClientByEmail(username)).thenReturn(client);

        UserDetails userDetails = clientDetailsService.loadUserByUsername(username);

        assertEquals(username, userDetails.getUsername());
        assertEquals(password, userDetails.getPassword());
        assertEquals(1, userDetails.getAuthorities().size());
        assertEquals(role, userDetails.getAuthorities().iterator().next().getAuthority());

        verify(clientService, times(1)).getClientByEmail(username);
    }

    @Test
    public void testLoadUserByUsername_ClientNotFound() {
        String username = "nonexistent@example.com";

        when(clientService.getClientByEmail(username)).thenReturn(null);

        try {
            clientDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            assertEquals("Client not found with email: " + username, e.getMessage());
        }

        verify(clientService, times(1)).getClientByEmail(username);
    }
}
