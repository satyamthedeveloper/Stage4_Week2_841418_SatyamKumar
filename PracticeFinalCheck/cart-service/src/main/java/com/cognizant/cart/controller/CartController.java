package com.cognizant.cart.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ExhangeServiceProxy.MenuItemExchangeServiceProxy;
import com.cognizant.model.MenuItem;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/carts")
@Slf4j
public class CartController {

	@Autowired
	MenuItemExchangeServiceProxy proxyService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
	public MenuItem getMenuItem(@PathVariable int id) {
		log.info("START");
		return proxyService.findById(id);
	}

}
