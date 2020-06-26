package com.cognizant.favorite.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.favorite.exceptions.EntityNotExistException;
import com.cognizant.favorite.model.Movie;
import com.cognizant.favorite.services.FavoriteMovieService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/movies")
@Slf4j
public class FavoriteController {

	@Autowired
	private FavoriteMovieService favoriteMovieService;
	
	// Controller to fetch favorite List
	@GetMapping("/{userId}/favorite")
	@HystrixCommand(fallbackMethod = "getDefaultMessage")
	public Iterable<Movie> getFavoriteMoviesCustomer(@PathVariable("userId") int userId){
		log.info("START");
		return favoriteMovieService.getFavoriteMoviesCustomer(userId);
	}
	
	// Controller to add in favorite List
	@PutMapping("/{userId}/{movieId}")
	public void addFavoriteMovieCustomer(@PathVariable("userId") int userId, @PathVariable("movieId") int movieId) {
		log.info("START");
		favoriteMovieService.addFavoriteMovieCustomer(userId, movieId);
		log.info("END");
	}
	
	// Controller to delete from favorite List
	@DeleteMapping("/{userId}/{movieId}")
	public void removeFavoriteMovieCustomer(@PathVariable("userId") int userId, @PathVariable("movieId") int movieId)
			throws EntityNotExistException {
		log.info("START");
		favoriteMovieService.removeFavoriteMovieCustomer(userId, movieId);
		log.info("END");
	}
	
	Iterable<Movie> getDefaultMessage(int id){
		Movie movie = new Movie();
		movie.setActive(false);
		movie.setBoxOffice("Default");
		movie.setDateOfLaunch(null);
		movie.setGenre("Default");
		movie.setHasTeaser(false);
		movie.setId(id);
		movie.setPosterLink("Default");
		movie.setTitle("Default");
		
		ArrayList<Movie> list = new ArrayList<Movie>();
		list.add(movie);
		
		return list;
	}
}
