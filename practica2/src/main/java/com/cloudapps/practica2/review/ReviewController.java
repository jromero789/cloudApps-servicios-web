package com.cloudapps.practica2.review;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/reviews")
public class ReviewController {
    
	@Autowired
	private ReviewService reviewService;

	@Autowired
	private ReviewMapper mapper;

	@GetMapping("/")
	public Collection<ReviewDTO> getReviews() {
		return mapper.toDTOs(reviewService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ReviewDTO> getReview(@PathVariable long id) {
		Review review = reviewService.findById(id);

		if(review != null){
			return ResponseEntity.ok(mapper.toDTO(review));
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
	public ResponseEntity<ReviewDTO> deleteReview(@PathVariable long id) {

		Review review = reviewService.findById(id);
		if (review != null) {
		reviewService.deleteById(id);
		return ResponseEntity.ok(mapper.toDTO(review));
		} else {
		return ResponseEntity.notFound().build();
		}
	}
}
