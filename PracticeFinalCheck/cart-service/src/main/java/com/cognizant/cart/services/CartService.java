package com.cognizant.cart.services;

import java.util.ArrayList;

import com.cognizant.cart.exceptions.ItemNotFoundException;
import com.cognizant.cart.model.MenuItem;

public interface CartService {

	//to add item in given user cart
	void addCartItem(int userId, int menuItemId) throws ItemNotFoundException;

	//fetch all items in given user cart
	ArrayList<MenuItem> getAllCartItems(int userId);

	//delete item from given user and cart
	void deleteCartItem(int userId, int menuItemId);

}
