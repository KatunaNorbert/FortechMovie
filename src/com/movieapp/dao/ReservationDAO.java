package com.movieapp.dao;

import java.util.List;

import com.movieapp.model.Reservation;
import com.movieapp.model.Show;

public interface ReservationDAO {
	
	public void addReservation(Reservation r);
	public Reservation removeReservation(int idUser);
	public List<Integer> userReservations(int uId);
}
