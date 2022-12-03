package com.cloudapps.practica2.book;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookMapper mapper;

	@GetMapping("/")
	public Collection<BookDTO> getBooks() {
		return mapper.toDTOs(bookService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> getBook(@PathVariable long id) {
		Book book = bookService.findById(id);

		if(book != null){
			return ResponseEntity.ok(mapper.toDTO(book));
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
	public ResponseEntity<BookDTO> deleteBook(@PathVariable long id) {

		Book book = bookService.findById(id);
		if (book != null) {
		bookService.deleteById(id);
		return ResponseEntity.ok(mapper.toDTO(book));
		} else {
		return ResponseEntity.notFound().build();
		}
	}

}
