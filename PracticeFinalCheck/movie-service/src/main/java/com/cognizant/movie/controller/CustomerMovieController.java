package com.cognizant.movie.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.movie.model.Movie;
import com.cognizant.movie.services.MovieService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/movies")
@Slf4j
public class CustomerMovieController {

	@Autowired
	private MovieService movieService;

	//fetch movie list for customer
	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public Iterable<Movie> getAllMoviesCustomer() {
		log.info("START");
		return movieService.getAllMoviesCustomer();
	}

	//fetch active movie list for customer
	@GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON)
	public Iterable<Movie> getActiveMoviesCustomer() {
		log.info("START");
		return movieService.getActiveMoviesCustomer();
	}

	//fetch movie for customer by id
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
	public Movie getMovieById(@PathVariable("id") int id) {
		log.debug("START");
		return movieService.getMovieById(id);
	}
}
