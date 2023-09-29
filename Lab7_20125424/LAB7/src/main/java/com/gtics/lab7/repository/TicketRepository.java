package com.gtics.lab7.repository;

import com.gtics.lab7.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Device, Integer> {
}

