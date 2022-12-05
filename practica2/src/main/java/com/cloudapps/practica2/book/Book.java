package com.cloudapps.practica2.book;

import java.util.List;

import com.cloudapps.practica2.review.Review;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Book {
 
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String summary;
    private String author;
    private String publisher;
    private int publicationYear;

    @OneToMany(mappedBy="book", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Book() {

	}

    public Book(String title, String summary, String author, String publisher, int publicationYear, List<Review> reviews) {
        super();
        this.title = title;
        this.summary = summary;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.reviews = reviews;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> review) {
        this.reviews = review;
    }
}
