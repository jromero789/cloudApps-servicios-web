package com.cloudapps.persistencia1.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.persistencia1.model.Airport;
import com.cloudapps.persistencia1.model.Flight;


public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByDepartureOrderByDateAsc(Airport departure);




}
