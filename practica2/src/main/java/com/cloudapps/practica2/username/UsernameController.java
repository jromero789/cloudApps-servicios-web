package com.cloudapps.practica2.username;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsernameController {
    
    @Autowired
	private UsernameService usernameService;

	@Autowired
	private UsernameMapper mapper;

	@GetMapping("/")
	public Collection<UsernameDTO> getUsers() {
		return mapper.toDTOs(usernameService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsernameDTO> getUser(@PathVariable long id) {
		Username user = usernameService.findById(id);

		if(user != null){
			return ResponseEntity.ok(mapper.toDTO(user));
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
	public ResponseEntity<UsernameDTO> deleteUser(@PathVariable long id) {

		Username user = usernameService.findById(id);
		if (user != null) {
			usernameService.deleteById(id);
			return ResponseEntity.ok(mapper.toDTO(user));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
