package com.cognizant.menuItem.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.menuItem.model.MenuItem;
import com.cognizant.menuItem.services.MenuItemService;

import lombok.extern.slf4j.Slf4j;

//Controller
@RestController
@RequestMapping("/menu-items")
@Slf4j
public class Controller {

	@Autowired
	MenuItemService menuItemSrevice;

	//provides list of all menu items
	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public Iterable<MenuItem> getAllMenuItems() {
		log.debug("START");
		return menuItemSrevice.getMenuItemListCustomer();
	}

	//provides list of menu item by given id
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON)
	public MenuItem getMenuItem(@PathVariable("id") Long id) {
		log.debug("START");
		return menuItemSrevice.getMenuItem(id);
	}

	//updates list of menu items by given data in response 
	@PutMapping
	public void modifyMenuItem(@RequestBody MenuItem menuItem) {
		log.debug("START");
		menuItemSrevice.modifyMenuItem(menuItem);
		log.debug("END");
	}
}
