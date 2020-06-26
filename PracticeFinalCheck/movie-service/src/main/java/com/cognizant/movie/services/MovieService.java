package com.cognizant.movie.services;

import com.cognizant.movie.model.Movie;

public interface MovieService {

	Iterable<Movie> getAllMoviesAdmin();

	void editMovieAdmin(Movie updateMovie, int movieId);

	Iterable<Movie> getAllMoviesCustomer();

	Iterable<Movie> getActiveMoviesCustomer();

}
