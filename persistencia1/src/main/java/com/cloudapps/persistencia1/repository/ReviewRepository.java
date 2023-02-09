package com.cloudapps.persistencia1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cloudapps.persistencia1.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    
}
