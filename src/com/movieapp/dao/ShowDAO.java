package com.movieapp.dao;

import java.util.List;

import com.movieapp.model.Show;

public interface ShowDAO {
	
	public void addShow(Show s);
	public void updateShow(Show s);
	public List<Show> listShow();
	public Show getShowByName(String name);
	public void removeShow(int id);
	public List<Show> getShowById(int id);
}
