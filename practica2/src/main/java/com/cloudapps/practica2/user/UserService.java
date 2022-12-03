package com.cloudapps.practica2.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.cloudapps.practica2.review.Review;

@Component
@SessionScope
public class UserService {

	private final ConcurrentMap<Long, User> users = new ConcurrentHashMap<>();
	private final AtomicLong nextId = new AtomicLong();
	

	public UserService() {
		save(new User("UserA", 
            "UserA@gmail.com",
			new ArrayList<Review>()
			));
		
        save(new User("UserB", 
            "UserB@gmail.com",
			new ArrayList<Review>()
			));
	}

	public Collection<User> findAll() {
		return users.values();
	}

    public User findById(long id) {
		return users.get(id);
	}

	public void save(User user) {
		long id = nextId.getAndIncrement();
		user.setId(id);
		this.users.put(id, user);
	}

	public void deleteById(long id) {
		this.users.remove(id);
	}
}