package com.cognizant.movie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.movie.dao.MovieDao;
import com.cognizant.movie.exceptions.MovieNotFoundException;
import com.cognizant.movie.model.Movie;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieDao movieDao;

	
	@Override
	public Iterable<Movie> getAllMoviesAdmin() {
		log.debug("START");
		return movieDao.findAll();
	}

	@Override
	public void editMovieAdmin(Movie updateMovie, int movieId) {
		// TODO Auto-generated method stub
		log.debug("START");
		updateMovie.setId(movieId);
		movieDao.save(updateMovie);
		log.debug("END");
//		md.editMovieAdmin(updateMovie, movieId);
	}

	@Override
	public Iterable<Movie> getAllMoviesCustomer() {
		log.debug("START");
		return movieDao.findAll();
	}

	@Override
	public Iterable<Movie> getActiveMoviesCustomer() {
		log.debug("START");
		return movieDao.findAllActive();
	}

	@Override
	public Movie getMovieById(int id) {
		log.debug("START");
		return movieDao.findById(id).orElseThrow(MovieNotFoundException::new);
	}

}
