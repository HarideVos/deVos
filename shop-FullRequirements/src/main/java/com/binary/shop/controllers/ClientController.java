package com.binary.shop.controllers;

import com.binary.shop.config.JwtUtil;
import com.binary.shop.config.ClientDetailsService;
import com.binary.shop.dtos.AuthenticationRequestDto;
import com.binary.shop.dtos.AuthenticationResponseDto;
import com.binary.shop.entities.Client;
import com.binary.shop.services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ClientDetailsService detailsService;

    @Autowired
    private JwtUtil jwtUti;

    @PostMapping("/register")
    public ResponseEntity<Object> registerClient(@RequestBody Client client) {

        return new ResponseEntity<>(clientService.createClient(client), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> createClientAuthToken(@RequestBody AuthenticationRequestDto request) throws Exception {
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
