package com.cloudapps.practica2.user;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserService {

	@Autowired
	private UserRepository userRepository;
	

	public Collection<User> findAll() {
		return userRepository.findAll();
	}

    public User findById(long id) {
		return userRepository.findById(id).orElseThrow();
	}

	public void deleteById(long id) {
		this.userRepository.deleteById(id);
	}
}