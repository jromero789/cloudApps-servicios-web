package com.cloudapps.persistencia1.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private Airplane airplane;
    private Date dateInitial;
    private Date dateFinal;
    private Number hours;
    @OneToOne
    private Mechanic mechanic;
    private String type;
    private String description;
    @OneToOne
    private Airport airport;

    public Review() {

	}

    public Review(Airplane airplane, Date dateInitial, Date dateFinal, Number hours, Mechanic mechanic, String type, String description, Airport airport) {
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

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
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

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
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

    public Airport getAirpot() {
        return airport;
    }

    public void setAirpot(Airport airport) {
        this.airport = airport;
    }
}
