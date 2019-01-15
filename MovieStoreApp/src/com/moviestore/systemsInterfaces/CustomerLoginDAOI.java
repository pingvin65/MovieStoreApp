package com.moviestore.systemsInterfaces;

import com.moviestore.model.CustomerLogin;

public interface CustomerLoginDAOI {
	
	/**
	 * 
	 * @param email is String
	 * @return view customer from ViewCustomer class
	 */
	public CustomerLogin getCustomerByEmail(String email);

	public CustomerLogin getCustomerByid(int customerid);
}
