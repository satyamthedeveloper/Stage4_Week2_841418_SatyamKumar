package com.cognizant.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping
	public Iterable<Movie> getAllMoviesCustomer() {
		log.info("START");
		return movieService.getAllMoviesCustomer();
	}

	@GetMapping("/active")
	public Iterable<Movie> getActiveMoviesCustomer(){
		log.info("START");
		return movieService.getActiveMoviesCustomer();
	}
}
