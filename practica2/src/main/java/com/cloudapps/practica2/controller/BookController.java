package com.cloudapps.practica2.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapps.practica2.model.Book;
import com.cloudapps.practica2.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public Collection<Book> getBooks() {
		return bookService.findAll();
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable long id) {
		Book book = bookService.findById(id);

		if(book != null){
			return ResponseEntity.ok(book);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// @PostMapping("/book")
	// public ResponseEntity<Book> createBook(@RequestBody Book book) {

	// 	bookService.save(book);

  	// 	return ResponseEntity.created();
	// }

	@DeleteMapping("/book/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable long id) {

		Book book = bookService.findById(id);
		if (book != null) {
		bookService.deleteById(id);
		return ResponseEntity.ok(book);
		} else {
		return ResponseEntity.notFound().build();
		}
	}

}
