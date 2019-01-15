package com.moviestore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.moviestore.model.ViewCustomer;
import com.moviestore.systemsInterfaces.ViewCustomerDAOI;
import com.moviestore.utility.OracleSQL;

public class ViewCustomerDAO implements ViewCustomerDAOI{

	OracleSQL emailVCus;
	ResultSet rs=null;
	ViewCustomer viewCustomer;
	
	@Override
	public ViewCustomer getStudentByEmail(String email) {
		// TODO Auto-generated method stub
		emailVCus = new OracleSQL();
		
	
		try {
			//rs = emailVCus.getData("SELECT email, password from view_customer WHERE email='"+ email +"'");
			rs = emailVCus.getData("SELECT  email, password FROM view_customer WHERE email='" + email.toString() +"'");
			while(rs.next()) {
				viewCustomer = new ViewCustomer(rs.getNString("email"), rs.getNString("password"));
			}
			rs.close();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return viewCustomer;
	}

}
