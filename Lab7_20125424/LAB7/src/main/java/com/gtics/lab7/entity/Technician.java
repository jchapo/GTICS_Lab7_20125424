package com.gtics.lab7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "technician")
@Getter
@Setter
public class Technician {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer TechnicianID;
    @Column(name = "FirstName", nullable = true)
    private String FirstName;
    @Column(name = "LastName", nullable = true)
    private String LastName;
    @Column(name = "Dni", nullable = true)
    private String Dni;
    @Column(name = "Phone", nullable = true)
    private String Phone;
    @Column(name = "Age", nullable = true)
    private Integer Age;


}
