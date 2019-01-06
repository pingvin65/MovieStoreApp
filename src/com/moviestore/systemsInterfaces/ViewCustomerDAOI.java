package com.moviestore.systemsInterfaces;

import com.moviestore.model.ViewCustomer;

public interface ViewCustomerDAOI {
	
	/**
	 * 
	 * @param email is String
	 * @return view customer from ViewCustomer class
	 */
	public ViewCustomer getStudentByEmail(String email);
}
