package com.movieapp.dao;

import com.movieapp.model.Movie;

import java.util.List;

public interface MovieDAO {
	
	public void addMovie(Movie m);
	public void updateMovie(Movie m);
	public List<Movie> listMovies();
	public Movie getMovieByName(Movie m);
	public Movie getMovieById(int id);
	public void removeMovie(int id);
	
}
