package com.cloudapps.practica2.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;



@RestController
@RequestMapping("/reviews")
public class ReviewController {
    
	@Autowired
	private ReviewService reviewService;

	@Autowired
	private ReviewMapper mapper;

	@GetMapping("/")
	public Page<ReviewDTO> getReviews(Pageable page) {
		return mapper.toDTOs(reviewService.findAll(page));
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

	@PostMapping("/")
	public ResponseEntity<ReviewDTO> createPost(@RequestBody ReviewDTO reviewDTO) {

		Review review = reviewService.save(mapper.toDomain(reviewDTO));

		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(review.getId()).toUri();

		return ResponseEntity.created(location).body(mapper.toDTO(review));
	}

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
