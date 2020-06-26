package com.cognizant.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.movie.model.Movie;
import com.cognizant.movie.services.MovieService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin/movies")
@Slf4j
public class AdminMovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping
	public Iterable<Movie> getAllMoviesAdmin() {
		log.info("START");
		return movieService.getAllMoviesAdmin();
	}

	@PutMapping("/{movieId}")
	public void editMovieAdmin(@RequestBody Movie updateMovie, @PathVariable("movieId") int movieId) {
		log.info("START");
		movieService.editMovieAdmin(updateMovie, movieId);
		log.info("END");
	}
}