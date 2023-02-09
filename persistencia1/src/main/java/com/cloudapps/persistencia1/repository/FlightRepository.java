package com.cloudapps.persistencia1.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cloudapps.persistencia1.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    
}
