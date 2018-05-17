package com.movieapp.dao;

import java.util.List;

import com.movieapp.model.User;

public interface UserDAO {
	
	public void addUser(User u);
	public void updatePerson(User u);
	public List<User> listUsers();
	public User getUserByName(User u);
	public void removeUser(int id);
}
