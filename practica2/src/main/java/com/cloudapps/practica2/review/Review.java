package com.cloudapps.practica2.review;

import com.cloudapps.practica2.username.Username;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Review {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long bookId;
    private String comment;
    private int rating;

    @OneToOne
    private Username username;
    
    public Review() {

    }

    public Review(Username username, String comment, int rating) {
        super();
        this.username = username;
        this.comment = comment;
        this.rating = rating;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    
    public Username getUsername() {
        return username;
    }

    public void setUserName(Username username) {
        this.username = username;
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
