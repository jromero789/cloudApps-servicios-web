package com.cloudapps.practica1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.cloudapps.practica1.model.Review;
import com.cloudapps.practica1.service.ReviewService;
import com.cloudapps.practica1.service.UserSession;

@Controller
public class ReviewController {
    
	@Autowired
	private ReviewService reviewService;

	@Autowired
	private UserSession userSession;
	
	@GetMapping("/review/new/{bookId}")
	public String newReviewForm(Model model, @PathVariable long bookId) {

        model.addAttribute("user", userSession.getUser());
        model.addAttribute("book", reviewService.findByBookId(0));

		return "new_review";
	}

	@PostMapping("/review/new/{bookId}")
	public String newReview(Model model, Review review, @PathVariable long bookId) {

		reviewService.save(review, bookId);

		userSession.setUser(review.getUser().getName());
		userSession.incNumPosts();

		model.addAttribute("numPosts", userSession.getNumPosts());

		return "saved_review";
	}

	
	@GetMapping("/review/{bookId}/{id}/delete")
	public String deleteReview(Model model, @PathVariable long bookId, @PathVariable long id) {

		reviewService.deleteById(id);
		
		return "redirect:/book/" + bookId;
	}
}
