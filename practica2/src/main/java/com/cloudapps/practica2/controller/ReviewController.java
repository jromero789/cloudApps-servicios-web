package com.cloudapps.practica2.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapps.practica2.model.Review;
import com.cloudapps.practica2.service.ReviewService;


@RestController
@RequestMapping("/reviews")
public class ReviewController {
    
	@Autowired
	private ReviewService reviewService;

	@GetMapping("/")
	public Collection<Review> getReviews() {
		return reviewService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Review> getReview(@PathVariable long id) {
		Review review = reviewService.findById(id);

		if(review != null){
			return ResponseEntity.ok(review);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// @PostMapping("/")
	// public ResponseEntity<Book> createBook(@RequestBody Book book) {

	// 	bookService.save(book);

  	// 	return ResponseEntity.created();
	// }

	@DeleteMapping("/{id}")
	public ResponseEntity<Review> deleteReview(@PathVariable long id) {

		Review review = reviewService.findById(id);
		if (review != null) {
		reviewService.deleteById(id);
		return ResponseEntity.ok(review);
		} else {
		return ResponseEntity.notFound().build();
		}
	}
}
