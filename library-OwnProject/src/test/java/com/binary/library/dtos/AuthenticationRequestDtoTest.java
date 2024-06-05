package com.binary.library.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthenticationRequestDtoTest {

    @Test
    void testConstructorAndGetters() {
        String username = "testUser";
        String password = "testPassword";
        AuthenticationRequestDto requestDto = new AuthenticationRequestDto();
        requestDto.setUserName(username);
        requestDto.setPassword(password);
        assertEquals(username, requestDto.getUserName());
        assertEquals(password, requestDto.getPassword());
    }

    @Test
    void testSetUserName() {
        AuthenticationRequestDto requestDto = new AuthenticationRequestDto();
        String username = "newUsername";
        requestDto.setUserName(username);
        assertEquals(username, requestDto.getUserName());
    }

    @Test
    void testSetPassword() {
        AuthenticationRequestDto requestDto = new AuthenticationRequestDto();
        String password = "newPassword";
        requestDto.setPassword(password);
        assertEquals(password, requestDto.getPassword());
    }
}
