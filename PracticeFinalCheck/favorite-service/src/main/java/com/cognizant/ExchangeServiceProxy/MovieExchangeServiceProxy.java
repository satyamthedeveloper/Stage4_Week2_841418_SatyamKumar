package com.cognizant.ExchangeServiceProxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.favorite.model.Movie;

//Feign client handler
@FeignClient("movie-ws")
public interface MovieExchangeServiceProxy {

	//to fetch movie list
	@GetMapping("/movies")
	public Movie getAllMoviesCustomer();
	
	
	//to fetch movie list by id
	@GetMapping("/movies/{id}")
	public Movie getMoviesCustomerById(@PathVariable("id") int id);
}
