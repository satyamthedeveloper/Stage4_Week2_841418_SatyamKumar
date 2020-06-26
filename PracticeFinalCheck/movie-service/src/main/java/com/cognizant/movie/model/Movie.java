package com.cognizant.movie.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "movie_list")
@Data
@Slf4j
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String boxOffice;
	
	@Column(name = "active")
	private boolean active;
	private Date dateOfLaunch;
	private String genre;
	private boolean hasTeaser;
	private String PosterLink;
	
	public Movie() {
		log.debug("Inside Movie Constructor");
	}
}
