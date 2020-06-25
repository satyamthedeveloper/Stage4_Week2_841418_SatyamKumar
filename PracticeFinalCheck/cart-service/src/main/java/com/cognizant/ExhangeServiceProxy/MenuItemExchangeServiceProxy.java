package com.cognizant.ExhangeServiceProxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.cart.model.MenuItem;

@FeignClient(name = "menu-item-service")
public interface MenuItemExchangeServiceProxy {

	// to fetch menu item from feign client
	@GetMapping("/menu-items/{id}")
	public MenuItem findMenuItemById(@PathVariable("id") int id);
}
