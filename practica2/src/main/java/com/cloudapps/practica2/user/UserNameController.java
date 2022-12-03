package com.cloudapps.practica2.user;

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
public class UserNameController {
    
    @Autowired
	private UserNameService userService;

	@GetMapping("/")
	public Collection<UserName> getUsers() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserName> getUser(@PathVariable long id) {
		UserName user = userService.findById(id);

		if(user != null){
			return ResponseEntity.ok(user);
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
	public ResponseEntity<UserName> deleteUser(@PathVariable long id) {

		UserName user = userService.findById(id);
		if (user != null) {
			userService.deleteById(id);
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
