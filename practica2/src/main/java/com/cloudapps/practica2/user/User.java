package com.cloudapps.practica2.user;

import java.util.List;

import com.cloudapps.practica2.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

    private Long id;
    private String name;
    private String email;
    
    @JsonIgnore
    private List<Review> reviews;

    public User(String name, String email, List<Review> reviews) {
        super();
        this.name = name;
        this.email = email;
        this.reviews = reviews;
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
    public List<Review> getReviews() {
        return reviews;
    }

    public void setId(List<Review> reviews) {
        this.reviews = reviews;
    }
}
