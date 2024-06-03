package com.library.library.controllers;


import com.library.library.config.JwtUtil;
import com.library.library.config.MemberDetailsService;
import com.library.library.dtos.AuthenticationRequestDto;
import com.library.library.dtos.AuthenticationResponseDto;
import com.library.library.entities.Member;
import com.library.library.services.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {
    @Autowired
    private MemberServiceImpl memberService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MemberDetailsService detailsService;

    @Autowired
    private JwtUtil jwtUti;

    @PostMapping("/register")
    public ResponseEntity<Object> registerMember(@RequestBody Member member) {

        return new ResponseEntity<>(memberService.createMember(member), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> createMemberAuthToken(@RequestBody AuthenticationRequestDto request) throws Exception {
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
