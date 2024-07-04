package com.airbnb.Entity;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name="favourite")
@Getter
@Setter
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private long id;
    @Column(name="is_fav",nullable = false)
    private boolean isFavourite = false;

    @ManyToOne
    @JoinColumn(name="property_user_id")
    private PropertyUser propertyUser;

    @ManyToOne
    @JoinColumn(name="property_id")
    private Property property;



}
