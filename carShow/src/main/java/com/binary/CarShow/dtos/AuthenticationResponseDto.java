package com.binary.CarShow.dtos;

import lombok.Data;
import lombok.Getter;

@Getter
public class AuthenticationResponseDto {
    private final String token;

    public AuthenticationResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}