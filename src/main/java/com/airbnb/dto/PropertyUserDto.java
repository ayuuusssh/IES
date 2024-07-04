package com.airbnb.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyUserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String userRole;
}
