package com.cloudapps.persistencia1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cloudapps.persistencia1.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    
}