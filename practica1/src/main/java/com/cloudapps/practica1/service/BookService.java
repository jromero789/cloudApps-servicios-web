package com.cloudapps.practica1.service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import com.cloudapps.practica1.model.Book;

@Service
public class BookService {
    
    private final ConcurrentMap<Long, Book> books = new ConcurrentHashMap<>();
	private final AtomicLong nextId = new AtomicLong();
	

	public BookService() {
		save(new Book("Title1", 
            "Summary1",
            "Author1",
            "Publisher1",
            2001));
		
        save(new Book("Title2", 
            "Summary2",
            "Author2",
            "Publisher2",
            2002));
	}

	public Collection<Book> findAll() {
		return books.values();
	}

    public Book findById(long id) {
		return books.get(id);
	}

	public void save(Book book) {
		long id = nextId.getAndIncrement();
		book.setId(id);
		this.books.put(id, book);
	}

	public void deleteById(long id) {
		this.books.remove(id);
	}
}
