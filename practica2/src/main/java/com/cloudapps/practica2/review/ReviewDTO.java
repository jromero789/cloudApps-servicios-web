package com.cloudapps.practica2.review;

record ReviewDTO(
    Long id, 
    Long bookId, 
    String comment, 
    int rating){
}
