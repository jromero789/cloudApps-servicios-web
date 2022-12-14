package com.cloudapps.practica1.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cloudapps.practica1.model.Review;
import com.cloudapps.practica1.model.User;

@Service
public class ReviewService {
    
    private final ConcurrentMap<Long, Review> reviews = new ConcurrentHashMap<>();
	private final AtomicLong nextId = new AtomicLong();

	public ReviewService() {
		save(new Review(new User("Jimena"), "comment11", 5), 0);
		save(new Review(new User("Ana"), "comment21", 3), 1);
		save(new Review(new User("Luis"), "comment22", 4), 1);
	}

	public Collection<Review> findAll() {
		return reviews.values();
	}

    public Review findById(long id) {
		return reviews.get(id);
	}

    public Collection<Review> findByBookId(long bookId) {
        return this.findAll().stream()
            .filter(r -> r.getBookId() == bookId)
            .collect(Collectors.toCollection(ArrayList::new));
    }

	public void save(Review review, long bookId) {
		long id = nextId.getAndIncrement();
		review.setId(id);
        review.setBookId(bookId);
		this.reviews.put(id, review);
	}

	public void deleteById(long id) {
		this.reviews.remove(id);
	}
}

