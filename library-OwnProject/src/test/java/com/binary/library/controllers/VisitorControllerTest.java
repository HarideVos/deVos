package com.binary.library.controllers;

import com.binary.library.config.JwtUtil;
import com.binary.library.config.VisitorDetailsService;
import com.binary.library.dtos.AuthenticationRequestDto;
import com.binary.library.dtos.AuthenticationResponseDto;
import com.binary.library.entities.Visitor;
import com.binary.library.services.VisitorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class VisitorControllerTest {

    @Mock
    private VisitorService visitorService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private VisitorDetailsService visitorDetailsService;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private VisitorController visitorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegisterVisitor() {
        Visitor visitor = new Visitor("John", "John@email.com", "12345678", "user"); // Create a sample visitor object
        when(visitorService.createVisitor(visitor)).thenReturn(visitor);

        ResponseEntity<Object> response = visitorController.registerVisitor(visitor);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(visitorService, times(1)).createVisitor(visitor);
    }

    @Test
    void testCreateVisitorAuthToken() throws Exception {
        AuthenticationRequestDto request = new AuthenticationRequestDto();
        UserDetails userDetails = mock(UserDetails.class);
        String jwtToken = "sample.jwt.token";

        when(visitorDetailsService.loadUserByUsername(request.getUserName())).thenReturn(userDetails);
        when(jwtUtil.generateToken(userDetails)).thenReturn(jwtToken);

        ResponseEntity<Object> response = visitorController.createVisitorAuthToken(request);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(jwtToken, ((AuthenticationResponseDto) response.getBody()));
        verify(authenticationManager, times(1)).authenticate(any());
        verify(visitorDetailsService, times(1)).loadUserByUsername(request.getUserName());
        verify(jwtUtil, times(1)).generateToken(userDetails);
    }
}