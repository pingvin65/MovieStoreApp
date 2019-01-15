package com.moviestore.systemsInterfaces;


public interface OrdersDAOI {
	
	public boolean insertOrder (int customerID);
	
	public int getLastID(int customerID);

}
