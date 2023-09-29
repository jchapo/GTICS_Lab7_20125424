package com.gtics.lab7.repository;

import com.gtics.lab7.dto.TecnicosPorPaisDto;
import com.gtics.lab7.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Integer> {

    @Query(value = "SELECT country as pais, count(*) as cantidad FROM employees GROUP BY country",
            nativeQuery = true)
    List<TecnicosPorPaisDto> obtenerEmpleadosPorPais();


}

