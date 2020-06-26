package com.cognizant.cart.controller;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.cart.exceptions.ItemNotFoundException;
import com.cognizant.cart.model.MenuItem;
import com.cognizant.cart.services.CartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

//Controller

@RestController
@RequestMapping("/carts")
@Slf4j
public class CartController {

	@Autowired
	private CartService cartService;
	
	//Adds given item to given users cart.
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable("userId") int userId, @PathVariable("menuItemId") int menuItemId)
			throws ItemNotFoundException {
		log.info("START");
		cartService.addCartItem(userId, menuItemId);
		log.info("END");
	}

	//fetch all the cart items of existing users
	@GetMapping(value="/{userId}", produces = MediaType.APPLICATION_JSON)
	@HystrixCommand(fallbackMethod = "getDefaultMessage")
	public ArrayList<MenuItem> getAllCartItems(@PathVariable("userId") int userId) {
		log.info("START");
		return cartService.getAllCartItems(userId);
	}

	//Delete item from users cart
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItems(@PathVariable("userId") int userId, @PathVariable("menuItemId") int menuItemId) {
		log.debug("START");
		cartService.deleteCartItem(userId, menuItemId);
		log.debug("END");
	}

	ArrayList<MenuItem> getDefaultMessage(int id) {
		MenuItem menuItem = new MenuItem();
		menuItem.setId(0);
		menuItem.setActive(false);
		menuItem.setCategory("default");
		menuItem.setDateOfLaunch(null);
		menuItem.setFreeDelivery(false);
		menuItem.setName("Default Item");
		menuItem.setPrice(0);
		
		ArrayList<MenuItem> returnList = new ArrayList<MenuItem>();
		returnList.add(menuItem);
		return returnList;
	}
}
