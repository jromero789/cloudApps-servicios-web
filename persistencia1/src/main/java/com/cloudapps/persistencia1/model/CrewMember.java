package com.cloudapps.persistencia1.model;

import jakarta.persistence.*;

@Entity
public class CrewMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeId;
    private String name;
    private String surname;
    private Position position;
    private String company;

    public enum Position{
        COMANDANTE,
        COPILOTO,
        SOBRECARGO
    }

    public CrewMember() {

	}

    public CrewMember(String employeeId, String name, String surname, Position position, String company) {
        super();
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.company = company;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "CrewMember [id=" + id + ", employeeId=" + employeeId + ", name=" + name + ", surname=" + surname
                + ", position=" + position + ", company=" + company + "]";
    }

    
}
