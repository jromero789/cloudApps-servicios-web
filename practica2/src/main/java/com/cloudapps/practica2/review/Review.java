package com.cloudapps.practica2.review;

import com.cloudapps.practica2.book.Book;
import com.cloudapps.practica2.username.Username;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Review {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;
    private int rating;

    @OneToOne
    private Username username;@OneToOne

    @JsonIgnore
    @ManyToOne
    private Book book;

    
    public Review() {

    }

    public Review(String comment, int rating, Username username, Book book) {
        super();
        this.comment = comment;
        this.rating = rating;
        this.username = username;
        this.book = book;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setUsername(Username username) {
        this.username = username;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    
}
