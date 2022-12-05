package com.cloudapps.practica2.review;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {
    
    @Autowired
	private ReviewRepository reviewRepository;


	public Page<Review> findAll(Pageable page) {
		return reviewRepository.findAll(page);
	}

    public Review findById(long id) {
		return reviewRepository.findById(id).orElseThrow();
	}

	public void deleteById(long id) {
		reviewRepository.deleteById(id);
	}
}

