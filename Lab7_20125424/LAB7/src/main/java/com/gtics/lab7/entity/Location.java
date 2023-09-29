package com.gtics.lab7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "location")
@Getter
@Setter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer LocationID;
    @Column(name = "City", nullable = true)
    private String City;
    @Column(name = "Country", nullable = true)
    private String Country;


}
