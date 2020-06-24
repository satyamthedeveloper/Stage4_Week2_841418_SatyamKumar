package com.cognizant.menuItem.dao;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.menuItem.model.MenuItem;

//Extends the Crud Repository to perforn crud operations
public interface MenuItemDao extends CrudRepository<MenuItem, Long> {

}
