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

public class VisitorControllerTest {

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
}