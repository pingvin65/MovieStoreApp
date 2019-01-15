package com.moviestore.model;

public class Orders {
	
	private int customerID;

	
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Orders(int customerID) {
		super();
		this.customerID = customerID;
	}


	public int getOrderID() {
		return customerID;
	}

	public void setOrderID(int customerID) {
		this.customerID = customerID;
	}

}
