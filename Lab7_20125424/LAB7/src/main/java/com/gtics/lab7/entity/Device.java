package com.gtics.lab7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "device")
@Getter
@Setter
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer DeviceID;
    @Column(name = "DeviceName", nullable = true)
    private String DeviceName;
    @Column(name = "DeviceType", nullable = true)
    private String DeviceType;
    @Column(name = "Model", nullable = true)
    private String Model;
    @Column(name = "SerialNumber", nullable = true)
    private String SerialNumber;
    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site SiteID;


}
