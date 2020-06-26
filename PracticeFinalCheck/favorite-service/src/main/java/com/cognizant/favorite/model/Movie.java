package com.cognizant.favorite.model;

import java.sql.Date;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

// Movie class to store movie from movie web service
@Data
@Slf4j
public class Movie {

	private int id;
	private String title;
	private String boxOffice;
	private boolean active;
	private Date dateOfLaunch;
	private String genre;
	private boolean hasTeaser;
	private String PosterLink;

	//constructor
	public Movie() {
		log.debug("Inside Movie Constructor");
	}
}
