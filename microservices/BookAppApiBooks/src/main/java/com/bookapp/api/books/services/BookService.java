package com.bookapp.api.books.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookapp.api.books.exceptions.BookNotFoundException;
import com.bookapp.api.books.model.Book;

@Service
public interface BookService {

	List<Book> getAllBooks();

	Book getBook(int id) throws BookNotFoundException;

	void deleteBook(int id) throws BookNotFoundException;

	ResponseEntity<Object> createBook(Book book);

	ResponseEntity<Object> updateBook(Book book, int id);

}
