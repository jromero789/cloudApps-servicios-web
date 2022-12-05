package com.cloudapps.practica2.book;

import java.net.URI;

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


@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookMapper mapper;

	@GetMapping("/")
	public Page<BookDTO> getBooks(Pageable page) {
		return mapper.toDTOs(bookService.findAll(page));
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

	@PostMapping("/")
	public ResponseEntity<BookDTO> createPost(@RequestBody BookDTO bookDTO) {

		Book book = bookService.save(mapper.toDomain(bookDTO));

		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();

		return ResponseEntity.created(location).body(mapper.toDTO(book));
	}

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
