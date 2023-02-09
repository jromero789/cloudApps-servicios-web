package com.cloudapps.persistencia1.model;

import jakarta.persistence.*;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String IATA;
    private String name;
    private String city;
    private String country;

    public Airport() {

	}

    public Airport(String IATA, String name, String city, String country) {
        super();
        this.IATA = IATA;
        this.name = name;
        this.city = city;
        this.country = country;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIATA() {
        return IATA;
    }

    public void setIATA(String IATA) {
        this.IATA = IATA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
