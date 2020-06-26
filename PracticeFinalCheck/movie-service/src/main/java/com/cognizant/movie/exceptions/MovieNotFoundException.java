package com.cognizant.movie.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MovieNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public MovieNotFoundException() {
		super("Movie Not Exist at given Id");
		log.debug("Movie Not Exist at given Id");
	}

}
