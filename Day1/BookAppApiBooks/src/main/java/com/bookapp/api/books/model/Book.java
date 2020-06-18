package com.bookapp.api.books.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Book {
	
	@Id
	private int id;
	private String title;
	private String author;
	private float price;
}
