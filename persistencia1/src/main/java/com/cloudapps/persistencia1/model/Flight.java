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
    private String airplane;
    private String departure;
    private String arrival;
    private Date date;
    private Float duration;

    public Flight() {

	}

    public Flight(String flightId, String company, String airplane, String departure, String arrival, Date date, Float duration) {
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

    public String getAirplane() {
        return airplane;
    }

    public void setAirplane(String airplane) {
        this.airplane = airplane;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
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
}
