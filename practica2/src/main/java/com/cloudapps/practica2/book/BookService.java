package com.cloudapps.practica2.book;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;


@Service
public class BookService {
    
    @Autowired
	private BookRepository bookRepository;

	@PostConstruct
	public void init() {

		bookRepository.save(new Book("Title1", 
            "Summary1",
            "Author1",
            "Publisher1",
            2001,
			new ArrayList<>()
		));
		
		bookRepository.save(new Book("Title2", 
            "Summary2",
            "Author2",
            "Publisher2",
            2002,
			new ArrayList<>()
		));
		
	}
	

	public Collection<Book> findAll() {
		return bookRepository.findAll();
	}

    public Book findById(long id) {
		return bookRepository.findById(id).orElseThrow();
	}

	public void deleteById(long id) {
		bookRepository.deleteById(id);
	}
}
