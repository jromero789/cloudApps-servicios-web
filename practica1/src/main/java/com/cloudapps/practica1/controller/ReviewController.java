package com.cloudapps.practica1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.cloudapps.practica1.model.Review;
import com.cloudapps.practica1.service.ReviewService;


@Controller
public class ReviewController {
    
	@Autowired
	private ReviewService reviewService;
	
	
	@PostMapping("/review/new")
	public String newReview(Model model, Review review, @PathVariable long bookId) {

		reviewService.save(review, bookId);

		return "redirect:/book/" + bookId;
	}

	
	@GetMapping("/review/{bookId}/{id}/delete")
	public String deleteReview(Model model, @PathVariable long bookId, @PathVariable long id) {

		reviewService.deleteById(id);
		
		return "redirect:/book/" + bookId;
	}
}
