package com.cloudapps.persistencia1;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.cloudapps.persistencia1.model.Airplane;
import com.cloudapps.persistencia1.model.Airport;
import com.cloudapps.persistencia1.model.CrewMember;
import com.cloudapps.persistencia1.model.Flight;
import com.cloudapps.persistencia1.model.Mechanic;
import com.cloudapps.persistencia1.model.Review;
import com.cloudapps.persistencia1.repository.AirplaneRepository;
import com.cloudapps.persistencia1.repository.AirportRepository;
import com.cloudapps.persistencia1.repository.CrewMemberRepository;
import com.cloudapps.persistencia1.repository.FlightRepository;
import com.cloudapps.persistencia1.repository.MechanicRepository;
import com.cloudapps.persistencia1.repository.ReviewRepository;

@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private AirplaneRepository airplaneRepository;
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private CrewMemberRepository crewMemberRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private MechanicRepository mechanicRepository;
    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public void run(String... args) {

        // Initialize db
        Airplane airplane = airplaneRepository.save(new Airplane("REG-001", "Boeing", "747", 500));
        
        Airport airportDeparture = airportRepository.save(new Airport("MAD", "Aeropuerto Madrid Barajas", "Madrid", "Spain"));
        Airport airportArrival = airportRepository.save(new Airport("EZE", "Aeropuerto Ezeiza", "Buenos Aires", "Argentina"));
        
        CrewMember crewMember = crewMemberRepository.save(new CrewMember("EMP-001", "Luis", "Canales", "co-piloto", "Iberia"));
        
        Flight flight = flightRepository.save(new Flight("FLIGHT-001", "Iberia", airplane, airportDeparture, airportArrival, new Date(System.currentTimeMillis()-20000000), (float) 10.5));
    
        Mechanic mechanic = mechanicRepository.save(new Mechanic("EMP-001", "Ana", "Correa", "Iberia", 2004, "fp"));

        Review review = reviewRepository.save(new Review(airplane, new Date(System.currentTimeMillis()-50000000), new Date(System.currentTimeMillis()), 30, mechanic, "repare", "Fix flaps", airportDeparture));
    
    
       review.setHours(27);
    
    
    }

}

