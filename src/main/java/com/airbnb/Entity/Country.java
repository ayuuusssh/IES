package com.airbnb.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="country")
@Getter
@Setter

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private long id;
    @Column(name="country_name", unique = true,nullable = false,length = 200)
    private String countryName;


}
