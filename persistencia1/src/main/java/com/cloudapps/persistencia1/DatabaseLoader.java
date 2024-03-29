package com.cloudapps.persistencia1;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.cloudapps.persistencia1.model.Airplane;
import com.cloudapps.persistencia1.model.Airport;
import com.cloudapps.persistencia1.model.CrewMember;
import com.cloudapps.persistencia1.model.Flight;
import com.cloudapps.persistencia1.model.Mechanic;
import com.cloudapps.persistencia1.model.Review;
import com.cloudapps.persistencia1.model.CrewMember.Position;
import com.cloudapps.persistencia1.model.Mechanic.Training;
import com.cloudapps.persistencia1.model.Review.Type;
import com.cloudapps.persistencia1.repository.AirplaneRepository;
import com.cloudapps.persistencia1.repository.AirportRepository;
import com.cloudapps.persistencia1.repository.CrewMemberRepository;
import com.cloudapps.persistencia1.repository.FlightRepository;
import com.cloudapps.persistencia1.repository.MechanicRepository;
import com.cloudapps.persistencia1.repository.ReviewRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

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
        Airplane airplane = airplaneRepository.save(new Airplane("REG-001", "Boeing", "747", 500, new ArrayList<>()));
        
        Airport airportMad = airportRepository.save(new Airport("MAD", "Aeropuerto Madrid Barajas", "Madrid", "Spain"));
        Airport airportEze = airportRepository.save(new Airport("EZE", "Aeropuerto Ezeiza", "Buenos Aires", "Argentina"));
        
        
        CrewMember crewMember = crewMemberRepository.save(new CrewMember("EMP-001", "Luis", "Canales", Position.COPILOTO, "Iberia", new ArrayList<>()));
        List<CrewMember> crewMembers = new ArrayList<>();
        crewMembers.add(crewMember);


        Flight flight = flightRepository.save(new Flight("FLIGHT-001", "Iberia", airplane, airportMad, airportEze, new Date(System.currentTimeMillis()-20000000), (float) 10.5, crewMembers));
        List<Flight> flights = new ArrayList<>();
        flights.add(flight);
        
        crewMember.setFlights(flights);
        crewMemberRepository.save(crewMember);

        Mechanic mechanic = mechanicRepository.save(new Mechanic("EMP-001", "Ana", "Correa", "Iberia", 2004, Training.FP));

        Review review1 = reviewRepository.save(new Review(airplane, new Date(System.currentTimeMillis()-50000000), new Date(System.currentTimeMillis()), 30, mechanic, Type.REPAIR, "Fix flaps", airportMad));
        Review review2 = reviewRepository.save(new Review(airplane, new Date(System.currentTimeMillis()-40000000), new Date(System.currentTimeMillis()), 50, mechanic, Type.REPAIR, "Fix wind", airportMad));
        List<Review> reviews = new ArrayList<>();
        reviews.add(review1);
        reviews.add(review2);

        airplane.setReviews(reviews);
        airplaneRepository.save(airplane);

        
        
        // 1. Para cada avión, mostrar el nombre y apellidos de los mecánicos
        // responsables de sus revisiones.

        List<Airplane> airplanesOut1 = airplaneRepository.findAll();
        System.out.println("1---");
        for(Airplane airplaneOut1 : airplanesOut1){
            System.out.println(airplaneOut1.getRegistration());
            Set<Mechanic> mechanicsOut1 = new HashSet<>();
            for(Review reviewOut1 : airplane.getReviews()){
                mechanicsOut1.add(reviewOut1.getMechanic());
            }
            for(Mechanic mechanicOut1 : mechanicsOut1){
                System.out.println(mechanicOut1.getName() + ", " + mechanicOut1.getSurname());
            }
        };

        // 2. (15%) Dado el nombre de una ciudad y una fecha, listado de los vuelos que han
        // despegado (origen) en los aeropuertos de esa ciudad en esa fecha, ordenados por
        // hora.
        String city = "Madrid";
        Date date = new Date(); // TODO: Filter by date

        Airport airportOut2 = airportRepository.findByCity(city); 
        List<Flight> flightsOut2 = flightRepository.findByDepartureOrderByDateAsc(airportOut2);
        System.out.println("2---");
        for(Flight flightOut2 : flightsOut2){
            System.out.println(flightOut2.getFlightId() + ", " + flightOut2.getDate() + ", " + flightOut2.getDeparture().getCity());
        };

         // 3. (15%) Dado el código de empleado de un tripulante, mostrar su nombre y apellidos y
        // las ciudades desde las que ha despegado junto con la fecha en que despegó.
        
        String employeeId = "EMP-001";
        CrewMember crewMemberOut3 = crewMemberRepository.findByEmployeeId(employeeId);
        System.out.println("3---");
        System.out.println(crewMemberOut3.getName() + ", " + crewMemberOut3.getSurname());
        for(Flight fligth : crewMember.getFlights()){
            System.out.println(fligth.getDeparture().getCity() + ", " + flight.getDate());
        }
        
        // 4. (20%) Para cada tripulante, mostrar su nombre y apellidos junto con su número total
        // de vuelos y la suma de horas de estos.

        List<CrewMember> crewMembersOut4 = crewMemberRepository.findAll();
        System.out.println("4---");

        for(CrewMember crewMemberOut4 : crewMembersOut4){
            int numFlights = crewMemberOut4.getFlights().size();
            double sumHours = crewMemberOut4.getFlights().stream().mapToDouble(Flight::getDuration).sum();
            System.out.println(crewMemberOut4.getName() + ", " + crewMemberOut4.getSurname() + ", " + numFlights + ", " + sumHours);
        }
        



        review1.setHours(27);
    
    
    }

}

