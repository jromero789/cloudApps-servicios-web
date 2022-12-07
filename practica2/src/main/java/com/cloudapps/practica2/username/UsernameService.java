package com.cloudapps.practica2.username;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public Username save(Username username) {
		return usernameRepository.save(username);
	}

	public void deleteById(long id) {
		this.usernameRepository.deleteById(id);
	}

	public boolean isValidEmail(UsernameDTO userDto){
		String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(userDto.email());
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}
}