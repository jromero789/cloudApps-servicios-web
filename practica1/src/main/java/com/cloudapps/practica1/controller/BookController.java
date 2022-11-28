package com.cloudapps.practica1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cloudapps.practica1.model.Book;
import com.cloudapps.practica1.service.BookService;
import com.cloudapps.practica1.service.ReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {
    
	@Autowired
	private BookService bookService;
	@Autowired
	private ReviewService reviewService;
	

	@GetMapping("/")
	public String showBooks(Model model, HttpSession session) {

		model.addAttribute("books", bookService.findAll());
		model.addAttribute("welcome", session.isNew());

		return "index";
	}

	@GetMapping("/book/new")
	public String newBookForm(Model model) {
        
		return "new_book";
	}
	
	@PostMapping("/book/new")
	public String newBook(Model model, Book book) {

		bookService.save(book);

		return "saved_book";
	}

	@GetMapping("/book/{id}")
	public String showBook(Model model, @PathVariable long id) {

		Book book = bookService.findById(id);

		model.addAttribute("book", book);
		model.addAttribute("reviews", reviewService.findByBookId(id));

		return "show_book";
	}
	
	@GetMapping("/book/{id}/delete")
	public String deleteBook(Model model, @PathVariable long id) {

		bookService.deleteById(id);
		
		return "deleted_book";
	}
}
