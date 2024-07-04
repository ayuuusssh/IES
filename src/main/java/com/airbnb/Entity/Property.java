package com.airbnb.Entity;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name="property")
@Getter
@Setter
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id", nullable = false)
    private long id;
    @Column(name="property_name",unique = true)
    private String propertyName;
    @Column(name="bedrooms",nullable = false)
    private String bedRooms;
    @Column(name="bathrooms",nullable = false)
    private String bathRooms;
    @Column(name="nightly_price",nullable = false)
    private int nightlyPrice;
    @Column(name="guests",nullable = false)
    private int guests;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;



}





