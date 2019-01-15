package com.moviestore.systemsInterfaces;

public interface CustomerDAOI {
	
	public String getCustomerByEmail(String email);
	
	public boolean inserData(String sql);
}
