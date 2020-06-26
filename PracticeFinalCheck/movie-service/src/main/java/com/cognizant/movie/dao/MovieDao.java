package com.cognizant.movie.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.movie.model.Movie;

@Repository
@Transactional
public interface MovieDao extends JpaRepository<Movie, Integer>{
	
	@Query(nativeQuery = true, value = "select * from movie_list mc where mc.active = 1")
	public ArrayList<Movie> findAllActive();

}
