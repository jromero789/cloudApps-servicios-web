package com.cloudapps.persistencia1.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String flightId;
    private String company;
    @OneToOne
    private Airplane airplane;
    @OneToOne
    private Airport departure;
    @OneToOne
    private Airport arrival;

    private Date date;
    private Float duration;

    public Flight() {

	}

    public Flight(String flightId, String company, Airplane airplane, Airport departure, Airport arrival, Date date, Float duration) {
        super();
        this.flightId = flightId;
        this.company = company;
        this.airplane = airplane;
        this.departure = departure;
        this.arrival = arrival;
        this.date = date;
        this.duration = duration;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    public void setArrival(Airport arrival) {
        this.arrival = arrival;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Flight [id=" + id + ", flightId=" + flightId + ", company=" + company + ", airplane=" + airplane
                + ", departure=" + departure + ", arrival=" + arrival + ", date=" + date + ", duration=" + duration
                + "]";
    }

    
}
