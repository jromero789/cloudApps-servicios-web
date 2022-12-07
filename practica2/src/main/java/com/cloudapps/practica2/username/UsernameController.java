package com.cloudapps.practica2.username;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/users")
public class UsernameController {
    
    @Autowired
	private UsernameService usernameService;

	@Autowired
	private UsernameMapper mapper;

	@GetMapping("/")
	public Page<UsernameDTO> getUsers(Pageable page) {
		return mapper.toDTOs(usernameService.findAll(page));
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

	@PostMapping("/")
	public ResponseEntity<UsernameDTO> createPost(@RequestBody UsernameDTO usernameDTO) {

		if(!usernameService.isValidEmail(usernameDTO)){
			return ResponseEntity.status(500).body(null);
		}
		
		Username username = usernameService.save(mapper.toDomain(usernameDTO));

		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(username.getId()).toUri();

		return ResponseEntity.created(location).body(mapper.toDTO(username));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<UsernameDTO> deleteUser(@PathVariable long id) {

		Username user = usernameService.findById(id);
		if (user != null && user.getReviews() != null && user.getReviews().isEmpty()) {
			usernameService.deleteById(id);
			return ResponseEntity.ok(mapper.toDTO(user));
		}else if(user != null && user.getReviews() != null && !user.getReviews().isEmpty()){
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
