package com.cognizant.cart.model;

import java.util.Date;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//Menu Item class to store Menu Item
@Data
@Slf4j
public class MenuItem {

	private int id;
	private String name;
	private float price;
	private boolean active;
	private Date dateOfLaunch;
	private String category;
	private boolean freeDelivery;

	// constructor
	public MenuItem() {
		log.info("Object created...");
	}
}
