package com.cognizant.favorite.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.favorite.model.Favorite;

public interface FavoriteDao extends JpaRepository<Favorite, Integer> {

	// to fetch list of favorite movies by user
	@Query(nativeQuery = true, value = "select * from favorite_movie fm where fm.user_id = :user_id")
	public ArrayList<Favorite> getFavoriteListByUserId(@Param("user_id") int user_id);

	// to fetch entity to be deleted.
	@Query(nativeQuery = true, value = "select * from favorite_movie fm where fm.user_id = :user_id and fm.movie_id = :movie_id")
	public Favorite getFavoriteByUserIdMovieId(@Param("user_id") int user_id, @Param("movie_id") int movie_id);
}
