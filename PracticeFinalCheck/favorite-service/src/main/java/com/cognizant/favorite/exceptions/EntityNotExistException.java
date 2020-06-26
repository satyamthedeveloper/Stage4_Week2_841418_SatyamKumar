package com.cognizant.favorite.exceptions;

// Entity not exist in table exception class
public class EntityNotExistException extends Exception {

	private static final long serialVersionUID = 1L;

	//constructor
	public EntityNotExistException() {
		super("Row does not exist to be deleted.");
	}
}
