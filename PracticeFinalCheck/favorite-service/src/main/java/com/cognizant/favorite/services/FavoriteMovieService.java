package com.cognizant.favorite.services;

import com.cognizant.favorite.exceptions.EntityNotExistException;
import com.cognizant.favorite.model.Movie;

public interface FavoriteMovieService {

	// service to fetch favorite movie list
	Iterable<Movie> getFavoriteMoviesCustomer(int userId);

	//service to add favorite to list
	void addFavoriteMovieCustomer(int userId, int movieId);

	//service to delete favorite movie from list
	void removeFavoriteMovieCustomer(int userId, int movieId) throws EntityNotExistException;

}
