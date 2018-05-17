package com.movieapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column(name="id")
	private int id;
	
	public Movie() {
		
	}
	
	public Movie(int id, String name, String genre, String description) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.description = description;
	}


	@Column(name="name")
	private String name;
	
	
	@Column(name="genre")
	private String genre;
	
	
	@Column(name="description")
	private String description;
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
}
