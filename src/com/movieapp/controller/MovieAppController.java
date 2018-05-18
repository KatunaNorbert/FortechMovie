package com.movieapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.movieapp.dao.MovieDAOImpl;
import com.movieapp.dao.ReservationDAOImpl;
import com.movieapp.dao.ShowDAOImpl;
import com.movieapp.dao.UserDAOImpl;
import com.movieapp.model.Movie;
import com.movieapp.model.Reservation;
import com.movieapp.model.Show;
import com.movieapp.model.User;

@Controller
public class MovieAppController {
	
	MovieDAOImpl movieDAO = new MovieDAOImpl();
	UserDAOImpl userDAO = new UserDAOImpl();
	ShowDAOImpl showDAO = new ShowDAOImpl();
	ReservationDAOImpl resDAO=new ReservationDAOImpl();
	static User me=new User();
	
	@RequestMapping(value = "")
	   public String Home() {
		return "home";
	   }
	
	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	   public ModelAndView logOut() {
		return new ModelAndView("home");
	   }
	
	 @RequestMapping(value = "/makeReservation", method = RequestMethod.GET)
	   public ModelAndView makeReservation(ModelMap model) {
		  model.addAttribute("myList",showDAO.listShow());
	      return new ModelAndView("reservation", "command", new Reservation());
	   }
	 
	 @RequestMapping(value = "/returnMain", method = RequestMethod.POST)
	   public String returnMain(ModelMap model) {
		  model.addAttribute("name",me.getName());
		  model.addAttribute("mList", movieDAO.listMovies());
	      return "main";
	   }
	 
	 @RequestMapping(value = "/returnAdminHome", method = RequestMethod.POST)
	   public String returnAdminHome(ModelMap model) {
		  model.addAttribute("name",me.getName());
		  model.addAttribute("mList", movieDAO.listMovies());
	      return "adminHome";
	   }
	 
   @RequestMapping(value = "/logInMVC", method = RequestMethod.GET)
   public ModelAndView login() {
      return new ModelAndView("login", "command", new User());
   }
   
   
   @RequestMapping(value = "/signUpp", method = RequestMethod.GET)
   public ModelAndView signUpp() {
      return new ModelAndView("signUp", "command", new User());
   }
   
   @RequestMapping(value = "/logIn", method = RequestMethod.POST)
   public ModelAndView showMain(@ModelAttribute("SpringWeb")User user,ModelMap model) {
	   if(user.getName().equals("Norbert") && user.getPassword().equals(userDAO.getUserByName(user).getPassword())) {
		   return new ModelAndView("adminHome");
	   }
	   if(userDAO.getUserByName(user) == null || !userDAO.getUserByName(user).getPassword().equals(user.getPassword()))
		   return new ModelAndView("login", "command", new User());
	   
	   me.setName(user.getName());
	   me.setId(userDAO.getUserByName(user).getId());
	   System.out.println(me.getId());
	   model.addAttribute("name", user.getName());
	   model.addAttribute("password",user.getPassword());
	   model.addAttribute("mList",movieDAO.listMovies());
      return new ModelAndView("main","command", new Movie());
   }
   
   
   @RequestMapping(value = "/showReservations", method = RequestMethod.GET)
   public ModelAndView showReservations(ModelMap model) {
      model.addAttribute("name", me.getName());
      List<Integer> shows=resDAO.userReservations(me.getId());
      System.out.println(shows);
      List<Show> reservations=new ArrayList<Show>();
      for(int ids:shows) {
    	  		System.out.println(showDAO.getShowById(ids));
    	  		for(Show s:showDAO.getShowById(ids)) {
    	  			reservations.add(s);
    	  		}
      }
      model.addAttribute("mList",reservations);
      return new ModelAndView("myReservations");
   }
   
   
   @RequestMapping(value = "/addReservation", method = RequestMethod.GET)
   public String addReservation(@ModelAttribute("SpringWeb")Reservation res, 
   ModelMap model) {
	  res.getIdShow();
	  Show s=showDAO.getShowById(res.getIdShow()).get(0);
	  int NumberOfSeats=s.getSeats();
	  if(NumberOfSeats==0) {
		  model.addAttribute("mList", movieDAO.listMovies());
		  return "reservation"; 
	  }
	  --NumberOfSeats;
	  s.setSeats(NumberOfSeats);
	  showDAO.updateShow(s);
	  res.setIdUser(me.getId());
	  resDAO.addReservation(res);
	  model.addAttribute("mList", movieDAO.listMovies());
      return "main";
   }
   
   
   @RequestMapping(value = "/addUser", method = RequestMethod.POST)
   public ModelAndView addUser(@ModelAttribute("SpringWeb")User user, 
   ModelMap model) {
	   me.setId(userDAO.getUserByName(user).getId());
	   me.setName(user.getName());
	  if(userDAO.getUserByName(user)!=null) {
		  return new ModelAndView("signUp", "command", new User()); 
	  }
	  userDAO.addUser(user);
      model.addAttribute("name", user.getName());
      model.addAttribute("age", user.getPassword());
      model.addAttribute("mList",movieDAO.listMovies());
      return new ModelAndView("main");
   }
   
   
   @RequestMapping(value = "/addUserMVC", method = RequestMethod.GET)
   public ModelAndView addUserMVC() {
      return new ModelAndView("addUser", "command", new User());
   }
   
   @RequestMapping(value = "/addUserADM", method = RequestMethod.POST)
   public ModelAndView addStudent(@ModelAttribute("SpringWeb")User user, 
   ModelMap model) {
	  if(userDAO.getUserByName(user)!=null) {
		  return new ModelAndView("signUp", "command", new User()); 
	  }
	  userDAO.addUser(user);
      return new ModelAndView("adminHome");
   }
   
   @RequestMapping(value = "/deleteUserMVC", method = RequestMethod.GET)
   public ModelAndView deleteUserMVC() {
      return new ModelAndView("deleteUser", "command", new User());
   }
   
   @RequestMapping(value = "/deleteUserADM", method = RequestMethod.POST)
   public ModelAndView deleteStudent(@ModelAttribute("SpringWeb")User user, 
   ModelMap model) {
	  userDAO.removeUser(user.getId());
      return new ModelAndView("adminHome");
   }
   
   @RequestMapping(value = "/addMovieMVC", method = RequestMethod.GET)
   public ModelAndView addMovieMVC() {
      return new ModelAndView("addMovie", "command", new Movie());
   }
   
   @RequestMapping(value = "/addMovie", method = RequestMethod.POST)
   public String addMovie(@ModelAttribute("SpringWeb")Movie m, 
   ModelMap model) {
	  model.addAttribute("name", me.getName());
      model.addAttribute("mList",movieDAO.listMovies());
      movieDAO.addMovie(m);;
      return "adminHome";
   }
   
   @RequestMapping(value = "/deleteMovieMVC", method = RequestMethod.GET)
   public ModelAndView deleteMovieMVC() {
      return new ModelAndView("deleteMovie", "command", new Movie());
   }
   
   @RequestMapping(value = "/deleteMovie", method = RequestMethod.POST)
   public String deleteMovie(@ModelAttribute("SpringWeb")Movie m, 
   ModelMap model) {
      movieDAO.removeMovie(m.getId());
      model.addAttribute("name", me.getName());
      model.addAttribute("mList",movieDAO.listMovies());
      return "adminHome";
   }
   
   @RequestMapping(value = "/updateMovieMVC", method = RequestMethod.GET)
   public ModelAndView updateMovieMVC() {
      return new ModelAndView("updateMovie", "command", new Movie());
   }
   
   @RequestMapping(value = "/updateMovie", method = RequestMethod.POST)
   public String updateMovie(@ModelAttribute("SpringWeb")Movie m, 
   ModelMap model) {
      movieDAO.updateMovie(m);
      model.addAttribute("name", me.getName());
      model.addAttribute("mList",movieDAO.listMovies());
      return "adminHome";
   }
   
   @RequestMapping(value = "/addShowMVC", method = RequestMethod.GET)
   public ModelAndView addShowMVC() {
      return new ModelAndView("addShow", "command", new Show());
   }
   
   @RequestMapping(value = "/addShow", method = RequestMethod.POST)
   public ModelAndView addShow(@ModelAttribute("SpringWeb")Show s, 
   ModelMap model) {
	  if(movieDAO.getMovieById(s.getIdMovie())==null) {
		  return new ModelAndView("addShow", "command", new Show());
	  }
	  showDAO.addShow(s);
	  model.addAttribute("name", me.getName());
	  return new ModelAndView("adminHome");
   }
   
   @RequestMapping(value = "/deleteShowMVC", method = RequestMethod.GET)
   public ModelAndView deleteShowMVC() {
      return new ModelAndView("deleteShow", "command", new Show());
   }
   
   @RequestMapping(value = "/deleteShow", method = RequestMethod.POST)
   public String deleteShow(@ModelAttribute("SpringWeb")Show s, 
   ModelMap model) {
	  showDAO.removeShow(s.getId());
	  model.addAttribute("name", me.getName());
      return "adminHome";
   }
}
