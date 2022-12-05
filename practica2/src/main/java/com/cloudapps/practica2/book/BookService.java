package com.cloudapps.practica2.book;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	

	public Page<Book> findAll(Pageable page) {
		return bookRepository.findAll(page);
	}

    public Book findById(long id) {
		return bookRepository.findById(id).orElseThrow();
	}

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public void deleteById(long id) {
		bookRepository.deleteById(id);
	}
}
