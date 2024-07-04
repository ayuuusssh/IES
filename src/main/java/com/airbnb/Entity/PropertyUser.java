package com.airbnb.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name="airbnb")
@Getter
@Setter

public class PropertyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    private long id;
    @Column(name = "first_name", nullable = false, length = 120)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 120)
    private String lastName;
    @Column(name="username",nullable = false,unique = true)
    private String username;
    @Column(name = "email", nullable = false,unique = true)
    private String email;
    @JsonIgnore
    @Column(name = "password", nullable = false, length = 400)
    private String password;
    @JsonIgnore
    @Column(name = "user_role", nullable = false, length = 120)
    private String userRole;
}


