package com.cloudapps.practica1.model;

public class Review {
    
    private Long id;
    private User user;
    private String comment;
    private int rating;
    
    public Review() {

    }

    public Review(User user, String comment, int rating) {
        super();
        this.user = user;
        this.comment = comment;
        this.rating = rating;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
