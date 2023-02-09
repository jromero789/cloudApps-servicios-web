package com.cloudapps.persistencia1.model;

import jakarta.persistence.*;

@Entity
public class Mechanic {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String employeeId;
    private String name;
    private String surname;
    private String company;
    private Number yearJoining;
    private String training;

    public Mechanic() {

	}

    public Mechanic(String employeeId, String name, String surname, String company, Number yearJoining, String training) {
        super();
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.company = company;
        this.yearJoining = yearJoining;
        this.training = training;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Number getYearJoining() {
        return yearJoining;
    }

    public void setYearJoining(Number yearJoining) {
        this.yearJoining = yearJoining;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }
}
