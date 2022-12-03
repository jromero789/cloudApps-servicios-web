package com.cloudapps.practica2.user;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserNameService {

	@Autowired
	private UserNameRepository userRepository;
	

	public Collection<UserName> findAll() {
		return userRepository.findAll();
	}

    public UserName findById(long id) {
		return userRepository.findById(id).orElseThrow();
	}

	public void deleteById(long id) {
		this.userRepository.deleteById(id);
	}
}