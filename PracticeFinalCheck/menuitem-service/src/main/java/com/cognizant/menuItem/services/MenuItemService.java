package com.cognizant.menuItem.services;

import com.cognizant.menuItem.model.MenuItem;

//Service Interface
public interface MenuItemService {

	//performs business logic about getting all data
	Iterable<MenuItem> getMenuItemListCustomer();
	//performs business logic about getting data by id
	MenuItem getMenuItem(Long id);
	//performs business logic about setting data in database
	void modifyMenuItem(MenuItem menuItem);

}
