package com.moviestore.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.moviestore.model.ViewCustomer;
import com.moviestore.systemsInterfaces.ViewCustomerDAOI;
import com.moviestore.utility.JDBCStatement;


public class ViewCustomerDAO implements ViewCustomerDAOI{


	ResultSet rs=null;
	ViewCustomer viewCustomer;
	private JDBCStatement jDBCStatement = null;
	private Statement statement = null;
	
	
	/**
	 * @param String email
	 * @return ViewCustomer
	 */
	@Override
	public ViewCustomer getStudentByEmail(String email) {
		
		try {

			statement = jDBCStatement.getConnection().createStatement();
			rs = statement.executeQuery("SELECT  email, password FROM view_customer WHERE email='" + email.toString() +"'");
			while(rs.next()) {
				viewCustomer = new ViewCustomer(rs.getNString("email"), rs.getNString("password"));
			}
			rs.close();
		
		} catch (SQLException | ClassNotFoundException | IOException e) {
		
			e.printStackTrace();
		}finally {
			try {
				
				jDBCStatement.jDBCStatementClose();
				if(rs != null && rs.isClosed() ) {
					rs.close();
				}
				if(statement != null && !statement.isClosed()) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return viewCustomer;
	}

}
