package com.movieapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column(name="id")
	private int id;
	
	@Column(name="idUser")
	private int idUser;
	
	@Column(name="idShow")
	private int idShow;

	public int getIdUser() {
		return idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdShow() {
		return idShow;
	}

	public void setIdShow(int idShow) {
		this.idShow = idShow;
	}
	
	
	
}
