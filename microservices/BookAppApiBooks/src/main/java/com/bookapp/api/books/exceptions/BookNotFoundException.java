package com.bookapp.api.books.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookNotFoundException extends Exception {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookNotFoundException.class);
	
	public BookNotFoundException(String string) {
		// TODO Auto-generated constructor stub
		LOGGER.info(string);
	}
}
