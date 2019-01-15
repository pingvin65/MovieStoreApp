package com.moviestore.model;

public class PersonRolesInMovies {
	private String personFname;
	private String personLname;
	private int orderinmovies;
	private int roulesID;
	private int movieID;
	
	
	public PersonRolesInMovies(String personFname, String personLname, int orderinmovies, int roulesID, int movieID) {
		super();
		this.personFname = personFname;
		this.personLname = personLname;
		this.orderinmovies = orderinmovies;
		this.roulesID = roulesID;
		this.movieID = movieID;
	}


	public String getPersonFname() {
		return personFname;
	}


	public void setPersonFname(String personFname) {
		this.personFname = personFname;
	}


	public String getPersonLname() {
		return personLname;
	}


	public void setPersonLname(String personLname) {
		this.personLname = personLname;
	}


	public int getOrderinmovies() {
		return orderinmovies;
	}


	public void setOrderinmovies(int orderinmovies) {
		this.orderinmovies = orderinmovies;
	}


	public int getRoulesID() {
		return roulesID;
	}


	public void setRoulesID(int roulesID) {
		this.roulesID = roulesID;
	}


	public int getMovieID() {
		return movieID;
	}


	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	
	

	
	
	
	
}
