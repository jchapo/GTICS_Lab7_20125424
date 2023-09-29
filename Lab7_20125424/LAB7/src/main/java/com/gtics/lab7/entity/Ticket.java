package com.gtics.lab7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "viajes")
@Getter
@Setter
public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer TicketID;
    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site SiteID;
    @ManyToOne
    @JoinColumn(name = "TechnicianID")
    private Technician TechnicianID;
    @Column(name = "Status", nullable = true)
    private String Status;
    @Column(name = "OpenedDate", nullable = true)
    private Integer OpenedDate;
    @Column(name = "ClosedDate", nullable = true)
    private Integer Lugares_idLugares;


}
