package com.moviestore.model;

public class CustomerHasOrders {
	private int ordersID;
	private int moviesID;
	private float price;
	
	
	public CustomerHasOrders() {
		super();
	}


	public CustomerHasOrders(int ordersID, int moviesID, float price) {
		super();
		this.ordersID = ordersID;
		this.moviesID = moviesID;
		this.price = price;
	}


	public int getordersID() {
		return ordersID;
	}


	public void setordersID(int ordersID) {
		this.ordersID = ordersID;
	}


	public int getMoviesID() {
		return moviesID;
	}


	public void setMoviesID(int moviesID) {
		this.moviesID = moviesID;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
