package com.binary.library.controllers;

import com.binary.library.config.JwtUtil;
import com.binary.library.config.VisitorDetailsService;
import com.binary.library.dtos.AuthenticationRequestDto;
import com.binary.library.dtos.AuthenticationResponseDto;
import com.binary.library.entities.Visitor;
import com.binary.library.services.VisitorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/visitor")
public class VisitorController {
    @Autowired
    private VisitorServiceImpl visitorService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private VisitorDetailsService detailsService;

    @Autowired
    private JwtUtil jwtUti;

    @PostMapping("/register")
    public ResponseEntity<Object> registerVisitor(@RequestBody Visitor visitor) {
        if(visitorService != null) {
            Visitor createdVisitor = visitorService.createVisitor(visitor);
            if (createdVisitor != null) {
                return new ResponseEntity<>(createdVisitor, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Failed to create visitor", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("Visitor service is not available", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> createVisitorAuthToken(@RequestBody AuthenticationRequestDto request) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        } catch (Exception e) {
            throw new Exception("Incorrect username or password",e);
        }
        final UserDetails userDetails = detailsService.loadUserByUsername(request.getUserName());
        final String jwt = jwtUti.generateToken(userDetails);
        return new ResponseEntity<>(new AuthenticationResponseDto(jwt), HttpStatus.ACCEPTED);
    }
}
