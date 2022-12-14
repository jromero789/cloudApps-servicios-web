package com.cloudapps.practica3.server.eoloplant;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EoloPlant {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;
    private String planning;


    public EoloPlant() {
    }
    
    public EoloPlant(String city) {
        this.city = city;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlanning() {
        return planning;
    }

    public void setPlanning(String planning) {
        this.planning = planning;
    }
    
    
}
