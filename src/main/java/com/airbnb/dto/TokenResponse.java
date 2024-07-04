package com.airbnb.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TokenResponse {
    private String type = "Bearer";
    private String token;
}