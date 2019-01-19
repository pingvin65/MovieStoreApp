package com.moviestore.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.moviestore.systemsInterfaces.CustomerDAOI;
import com.moviestore.utility.JDBCStatement;


public class CustomerDAO implements CustomerDAOI {

	
	private JDBCStatement jDBCStatement;
	private ResultSet rs = null;
	/**
	 * @return String email
	 */
	@Override
	public String getCustomerByEmail(String email) {

		String email2 = null;
		Statement statement = null;
		try {
			
			jDBCStatement = new JDBCStatement();
			statement = jDBCStatement.getConnection().createStatement();
			rs = statement.executeQuery("SELECT email FROM view_customer WHERE email='" + email + "'");
		
			if (rs.next()) { //
				email2 = rs.getNString("email");
			}

		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}finally {
			try {
				
				jDBCStatement.jDBCStatementClose();
				if (!rs.isClosed()) {
					rs.close();
				}

				
				if (!statement.isClosed()) {
					statement.close();
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}

		return email2;
	}

	/**
	 * @return  boolean  if CUSTOMER created
	 */
	@Override
	public boolean inserData(String sql) {
		boolean created = false;
		PreparedStatement ps = null;
		try {
			jDBCStatement = new JDBCStatement();
			ps = jDBCStatement.getConnection().prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			ps.execute();
			created = true;

		} catch (ClassNotFoundException | SQLException | IOException e) {

			e.printStackTrace();
		}finally {
			try {
				
				jDBCStatement.jDBCStatementClose();
				if (!rs.isClosed()) {
					rs.close();
				}
				if (!ps.isClosed()) {
					ps.close();
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}

		return created;

	}

}
