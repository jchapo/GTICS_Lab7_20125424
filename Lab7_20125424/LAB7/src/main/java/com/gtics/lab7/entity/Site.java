package com.gtics.lab7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "site")
@Getter
@Setter
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer SiteID;
    @Column(name = "SiteName", nullable = true)
    private String SiteName;
    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Location LocationID;
    @Column(name = "InstallationDate", nullable = true)
    private LocalDate InstallationDate;
    @Column(name = "Latitude", nullable = true)
    private String Latitude;
    @Column(name = "Longitude", nullable = true)
    private String Longitude;

}
