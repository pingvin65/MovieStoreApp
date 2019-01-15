package com.moviestore.model;

public class CustomerFavMovie {
	
//	movies.moviesid, movies.title, movies.score,movies.runtime, 
//	movies.price, customer_favorite_movies.customerid
	private int consumerfmID;
	private int moviesID;
	private int customerID;
	private int runtime;
	private String title;
	private float price;
	private float score;
	
	
	
	
	
	public CustomerFavMovie() {
		super();
	}
	public CustomerFavMovie(int consumerfmID, int moviesID, int customerID, int runtime, String title, float price, float score) {
		super();
		this.consumerfmID = consumerfmID;
		this.moviesID = moviesID;
		this.customerID = customerID;
		this.runtime = runtime;
		this.title = title;
		this.price = price;
		this.score = score;
	}
	public int getMoviesID() {
		return moviesID;
	}
	public void setMoviesID(int moviesID) {
		this.moviesID = moviesID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getConsumerfmID() {
		return consumerfmID;
	}
	public void setConsumerfmID(int consumerfmID) {
		this.consumerfmID = consumerfmID;
	}
	
	

}
