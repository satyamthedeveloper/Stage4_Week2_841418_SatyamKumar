package com.cognizant.cart.exceptions;

public class ItemNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	public ItemNotFoundException() {
		super("Item not found.");
	}
}
