package com.cloudapps.practica2.username;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UsernameService {

	@Autowired
	private UsernameRepository userRepository;
	

	public Collection<Username> findAll() {
		return userRepository.findAll();
	}

    public Username findById(long id) {
		return userRepository.findById(id).orElseThrow();
	}

	public void deleteById(long id) {
		this.userRepository.deleteById(id);
	}
}