package com.cloudapps.practica2.review;

import com.cloudapps.practica2.username.Username;

record ReviewDTO(
    Long id, 
    Long bookId, 
    String comment, 
    int rating, 
    Username username){
}
