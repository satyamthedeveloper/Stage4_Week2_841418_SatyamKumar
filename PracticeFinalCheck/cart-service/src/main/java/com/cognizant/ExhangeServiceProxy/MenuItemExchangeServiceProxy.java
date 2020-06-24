package com.cognizant.ExhangeServiceProxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.model.MenuItem;

@FeignClient(name = "menu-item-service")
public interface MenuItemExchangeServiceProxy {

	@GetMapping("/menu-items/{id}")
	public MenuItem findById(@PathVariable("id") int id);
}
