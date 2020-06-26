package com.cognizant.favorite.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ExchangeServiceProxy.MovieExchangeServiceProxy;
import com.cognizant.favorite.dao.FavoriteDao;
import com.cognizant.favorite.exceptions.EntityNotExistException;
import com.cognizant.favorite.model.Favorite;
import com.cognizant.favorite.model.Movie;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FavoriteMovieServiceImpl implements FavoriteMovieService {

	@Autowired
	MovieExchangeServiceProxy movieExchange;

	@Autowired
	FavoriteDao favoriteDao;

	@Override
	public Iterable<Movie> getFavoriteMoviesCustomer(int userId) {
		log.debug("START");
		ArrayList<Favorite> favoriteList = favoriteDao.getFavoriteListByUserId(userId);
		log.debug("Favorite movie count: " + Integer.toString(favoriteList.size()));
		ArrayList<Movie> movieList = new ArrayList<Movie>();

		if (favoriteList.size() > 0) {
			for (Favorite favorite : favoriteList) {
				movieList.add(movieExchange.getMoviesCustomerById(favorite.getMovie_id()));
			}
		}

		return movieList;
	}

	@Override
	public void addFavoriteMovieCustomer(int userId, int movieId) {
		log.debug("START");
		Movie movie = movieExchange.getMoviesCustomerById(movieId);

		if (!movie.getTitle().isEmpty()) {
			Favorite favorite = new Favorite();
			favorite.setMovie_id(movieId);
			favorite.setUser_id(userId);

			favoriteDao.save(favorite);
			log.debug("Row insertion successful.");
		} else {
			log.debug("Movie does not exist to add in given user");
		}

		log.debug("END");
	}

	@Override
	public void removeFavoriteMovieCustomer(int userId, int movieId) throws EntityNotExistException {
		log.debug("START");
		Movie movie = movieExchange.getMoviesCustomerById(movieId);

		if (!movie.getTitle().isEmpty()) {
			Favorite favorite = favoriteDao.getFavoriteByUserIdMovieId(userId, movieId);
			
			if(favorite.getId()>0) {
				favoriteDao.delete(favorite);
				log.debug("Row insertion successful.");
			}
			else {
				log.debug("Row does not exist to be deleted.");
				throw new EntityNotExistException();
			}
			
			
		} else {
			log.debug("Movie does not exist. Please Check movie id.");
		}

		log.debug("END");
	}

}
