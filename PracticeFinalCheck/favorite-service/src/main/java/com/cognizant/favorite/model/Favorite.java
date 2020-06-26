package com.cognizant.favorite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//Entity Class
@Entity
@Table(name = "favorite_movie")
@Data
@Slf4j
public class Favorite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name = "user_id")
	int user_id;
	@Column(name = "movie_id")
	int movie_id;

	//constructor
	public Favorite() {
		log.debug("Favoriet Object Created");
	}
}
