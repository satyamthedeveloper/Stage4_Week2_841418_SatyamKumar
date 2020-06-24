package com.bookapp.api.books.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookapp.api.books.doa.BookRepository;
import com.bookapp.api.books.exceptions.BookNotFoundException;
import com.bookapp.api.books.model.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

	@Override
	public List<Book> getAllBooks() {
		LOGGER.debug("START");
		return bookRepository.findAll();
	}

	@Override
	public Book getBook(int id) throws BookNotFoundException {
		LOGGER.debug("START");
		Optional<Book> book = bookRepository.findById(id);
		if(!book.isPresent()) {
			throw new BookNotFoundException("id-"+id);
		}
		LOGGER.debug("END");
		return book.get();
	}

	@Override
	public void deleteBook(int id) throws BookNotFoundException {
		LOGGER.debug("START");
		try {
		bookRepository.deleteById(id);
		}catch (IllegalArgumentException e) {
			throw new BookNotFoundException("id-"+id);
		}
		LOGGER.debug("END");
	}

	@Override
	public ResponseEntity<Object> createBook(Book book) {
		LOGGER.debug("START");
		Book savedBook = bookRepository.save(book);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedBook.getId())
				.toUri();
		LOGGER.debug("END");
		return ResponseEntity.created(location).build();	
	}

	@Override
	public ResponseEntity<Object> updateBook(Book book, int id) {
		LOGGER.debug("START");
		Optional<Book> bookOptional = bookRepository.findById(id);
		if(!bookOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		book.setId(id);
		bookRepository.save(book);
		LOGGER.debug("END");
		return ResponseEntity.noContent().build();
	}
}
