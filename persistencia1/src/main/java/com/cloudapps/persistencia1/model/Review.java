package com.cloudapps.persistencia1.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String airplane;
    private Date dateInitial;
    private Date dateFinal;
    private Number hours;
    private String mechanic;
    private String type;
    private String description;
    private String airport;

    public Review() {

	}

    public Review(String airplane, Date dateInitial, Date dateFinal, Number hours, String mechanic, String type, String description, String airport) {
        super();
        this.airplane = airplane;
        this.dateInitial = dateInitial;
        this.dateFinal = dateFinal;
        this.hours = hours;
        this.mechanic = mechanic;
        this.type = type;
        this.description = description;
        this.airport = airport;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirplane() {
        return airplane;
    }

    public void setAirplane(String registration) {
        this.airplane = registration;
    }

    public Date getDateInitial() {
        return dateInitial;
    }

    public void setDateInitial(Date manufacturer) {
        this.dateInitial = manufacturer;
    }

    public Date getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(Date model) {
        this.dateFinal = model;
    }

    public Number getHours() {
        return hours;
    }

    public void setHours(Number hours) {
        this.hours = hours;
    }

    public String getMechanic() {
        return mechanic;
    }

    public void setMechanic(String mechanic) {
        this.mechanic = mechanic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAirpot() {
        return airport;
    }

    public void setAirpot(String airport) {
        this.airport = airport;
    }
}
