package com.cognizant.menuItem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Exception class which returns NOT FOUND status 404 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MenuItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MenuItemNotFoundException() {
		super("Menu Item does not exist");
	}

}
