package com.cloudapps.practica2.book;

import java.util.List;

import com.cloudapps.practica2.review.Review;

record BookDTO(
    Long id, 
    String title, 
    String summary, 
    String author, 
    String publisher, 
    int publicationYear, 
    List<Review> reviews) {
}
