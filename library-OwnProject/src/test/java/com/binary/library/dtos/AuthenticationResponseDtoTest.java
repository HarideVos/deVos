package com.binary.library.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthenticationResponseDtoTest {

    @Test
    void testConstructorAndGetters() {
        String token = "sampleToken";
        AuthenticationResponseDto responseDto = new AuthenticationResponseDto(token);
        assertEquals(token, responseDto);
    }
}
