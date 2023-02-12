package com.cloudapps.persistencia1.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String registration;
    private String manufacturer;
    private String model;
    private Number flightHours;

    @OneToMany
    private List<Review> reviews;

    public Airplane() {

	}

    public Airplane(String registration, String manufacturer, String model, Number flightHours, List<Review> reviews) {
        super();
        this.registration = registration;
        this.manufacturer = manufacturer;
        this.model = model;
        this.flightHours = flightHours;
        this.reviews = reviews;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Number getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(Number flightHours) {
        this.flightHours = flightHours;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Airplane [id=" + id + ", registration=" + registration + ", manufacturer=" + manufacturer + ", model="
                + model + ", flightHours=" + flightHours + ", reviews=" + reviews + "]";
    }

    
    
}
