package com.moviestore.beans;


/**
 * 
 * @author Sasa Budai
 *
 */
public class PersonRolesInMoviesBean {

	private String personFname;
	private String personLname;
	private int orderinmovies;
	private int roulesID;
	private int movieID;

	
	/**
	 * 
	 */
	public PersonRolesInMoviesBean() {
		super();
	}

	
	/**
	 * 
	 * @param personFname as String
	 * @param personLname as String 
	 * @param orderinmovies as int
	 * @param roulesID as int
	 * @param movieID as int
	 */
	public PersonRolesInMoviesBean(String personFname, String personLname, int orderinmovies, int roulesID,
			int movieID) {
		super();
		this.personFname = personFname;
		this.personLname = personLname;
		this.orderinmovies = orderinmovies;
		this.roulesID = roulesID;
		this.movieID = movieID;
	}

	
	/**
	 * 
	 * @return personFname as String
	 */
	public String getPersonFname() {
		return personFname;
	}

	
	/**
	 * 
	 * @param personFname as String
	 */
	public void setPersonFname(String personFname) {
		this.personFname = personFname;
	}

	
	/**
	 * 
	 * @return personLname as String
	 */ 
	public String getPersonLname() {
		return personLname;
	}

	
	/**
	 * 
	 * @param personLname as String
	 */
	public void setPersonLname(String personLname) {
		this.personLname = personLname;
	}

	
	/**
	 * 
	 * @return orderinmovies as int 
	 */
	public int getOrderinmovies() {
		return orderinmovies;
	}

	
	/**
	 * 
	 * @param orderinmovies as int 
	 */
	public void setOrderinmovies(int orderinmovies) {
		this.orderinmovies = orderinmovies;
	}

	
	/**
	 * 
	 * @return as int
	 */
	public int getRoulesID() {
		return roulesID;
	}

	
	/**
	 * 
	 * @param roulesID as int
	 */
	public void setRoulesID(int roulesID) {
		this.roulesID = roulesID;
	}

	
	/**
	 * 
	 * @return movieID as int 
	 */
	public int getMovieID() {
		return movieID;
	}

	
	/**
	 * 
	 * @param movieID as int
	 */
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

}
