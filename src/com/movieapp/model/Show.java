package com.movieapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MovieShow")
public class Show {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private String date;
	
	@Column(name="seats")
	private int seats;
	
	@Column(name="idMovie")
	private int idMovie;
	
	
	
	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

}
