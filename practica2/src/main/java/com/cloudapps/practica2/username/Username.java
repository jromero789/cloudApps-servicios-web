package com.cloudapps.practica2.username;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Username {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    

    public Username(){

    }
    
    public Username(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
