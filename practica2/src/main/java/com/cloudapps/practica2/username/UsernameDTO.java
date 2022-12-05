package com.cloudapps.practica2.username;

import java.util.List;

import com.cloudapps.practica2.review.Review;

record UsernameDTO(
    Long id, 
    String name, 
    String email, 
    List<Review> reviews){
}