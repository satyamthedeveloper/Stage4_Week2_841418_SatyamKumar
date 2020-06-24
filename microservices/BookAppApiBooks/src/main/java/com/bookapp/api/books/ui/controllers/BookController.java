package com.bookapp.api.books.ui.controllers;


import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.api.books.exceptions.BookNotFoundException;
import com.bookapp.api.books.model.Book;
import com.bookapp.api.books.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookSerive;

	private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

	@PostMapping
	public ResponseEntity<Object> createBook(@RequestBody Book book) {
		LOGGER.debug("START");
		return bookSerive.createBook(book);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks() {
		LOGGER.debug("START");
		return bookSerive.getAllBooks();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
	public Book getBook(@PathVariable("id") int id) throws BookNotFoundException {
		LOGGER.debug("START");
		return bookSerive.getBook(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable("id") int id) {
		LOGGER.debug("START");
		return bookSerive.updateBook(book, id);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable("id") int id) throws BookNotFoundException {
		LOGGER.debug("START");
		bookSerive.deleteBook(id);
		LOGGER.debug("END");
	}
}
