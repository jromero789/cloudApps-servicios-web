package com.cloudapps.practica2.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BookService {
    
    @Autowired
	private BookRepository bookRepository;


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
