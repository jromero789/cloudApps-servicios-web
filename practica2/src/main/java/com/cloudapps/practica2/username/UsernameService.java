package com.cloudapps.practica2.username;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
public class UsernameService {

	@Autowired
	private UsernameRepository usernameRepository;
	

	public Page<Username> findAll(Pageable page) {
		return usernameRepository.findAll(page);
	}

    public Username findById(long id) {
		return usernameRepository.findById(id).orElseThrow();
	}

	public void deleteById(long id) {
		this.usernameRepository.deleteById(id);
	}
}