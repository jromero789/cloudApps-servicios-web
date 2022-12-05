package com.cloudapps.practica2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloudapps.practica2.book.Book;
import com.cloudapps.practica2.book.BookRepository;
import com.cloudapps.practica2.review.Review;
import com.cloudapps.practica2.review.ReviewRepository;
import com.cloudapps.practica2.username.Username;
import com.cloudapps.practica2.username.UsernameRepository;

import jakarta.annotation.PostConstruct;


@Component
public class DatabaseInitializer {
    
    @Autowired
	private BookRepository bookRepository;

	@Autowired
	private ReviewRepository reviewRepository;
    
    @Autowired
	private UsernameRepository usernameRepository;

    @PostConstruct
	public void init() {

		Username username1 = new Username("Name1", "email1@email.com");
		usernameRepository.save(username1);

		Username username2 = new Username("Name2", "email2@email.com");
		usernameRepository.save(username2);

		Book book1 = new Book("Title1", 
            "Summary1",
            "Author1",
            "Publisher1",
            2001,
			new ArrayList<>()
		);
		bookRepository.save(book1);

		Book book2 = new Book("Title2", 
            "Summary2",
            "Author2",
            "Publisher2",
            2002,
			new ArrayList<>()
		);
		bookRepository.save(book2);

		Review review11 = new Review("Comment1", 4, username1, book1);
		reviewRepository.save(review11);
		Review review12 = new Review("Comment2", 4, username2, book1);
		reviewRepository.save(review12);
	}
}
