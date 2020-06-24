package com.cognizant.menuItem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.menuItem.dao.MenuItemDao;
import com.cognizant.menuItem.exceptions.MenuItemNotFoundException;
import com.cognizant.menuItem.model.MenuItem;

import lombok.extern.slf4j.Slf4j;

//Implements MenuItemService
@Service
@Slf4j
public class MenuItemServiceImpl implements MenuItemService {

	@Autowired
	private MenuItemDao menuItemDao;

	public Iterable<MenuItem> getMenuItemListCustomer() {
		log.debug("START");
		return menuItemDao.findAll();
	}

	public MenuItem getMenuItem(int id) {
		log.debug("START");
		return menuItemDao.findById(id).orElseThrow(MenuItemNotFoundException::new);
	}

	public void modifyMenuItem(MenuItem menuItem) {
		log.debug("START");
		menuItemDao.save(menuItem);
		log.debug("UPDATED...");
	}

}
