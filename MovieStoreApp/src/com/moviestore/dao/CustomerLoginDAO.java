package com.moviestore.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.moviestore.model.CustomerLogin;
import com.moviestore.systemsInterfaces.CustomerLoginDAOI;
import com.moviestore.utility.JDBCStatement;

public class CustomerLoginDAO implements CustomerLoginDAOI {

	/**
	 * @param String email
	 * @return CustomerLogin
	 */
	@Override
	public CustomerLogin getCustomerByEmail(String email) {
		JDBCStatement jDBCStatement = null;
		ResultSet rs = null;
		CustomerLogin viewCustomer = null;
		Statement statement = null;

		try {
			jDBCStatement = new JDBCStatement();
			statement = jDBCStatement.getConnection().createStatement();
			// rs = emailVCus.getData("SELECT email, password from view_customer WHERE
			// email='"+ email +"'");
			rs = statement
					.executeQuery("SELECT  customerid, email, password, frst_name FROM customer_login WHERE email='"
							+ email.toString() + "'");
			while (rs.next()) {
				viewCustomer = new CustomerLogin(rs.getInt("customerid"), rs.getNString("email"),
						rs.getNString("password"), rs.getNString("frst_name"));
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {

			e.printStackTrace();
		} finally {
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (statement != null && !statement.isClosed()) {
					statement.close();
				}

				jDBCStatement.jDBCStatementClose();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return viewCustomer;
	}

	/**
	 * @param int customerid
	 * @return CustomerLogin
	 */
	@Override
	public CustomerLogin getCustomerByid(int customerid) {
		// TODO Auto-generated method stub
		JDBCStatement jDBCStatement = null;
		ResultSet rs = null;
		CustomerLogin viewCustomer = null;
		Statement statement = null;

		try {
			jDBCStatement = new JDBCStatement();
			statement = jDBCStatement.getConnection().createStatement();
			// rs = emailVCus.getData("SELECT email, password from view_customer WHERE
			// email='"+ email +"'");
			rs = statement.executeQuery(
					"SELECT  customerid, email, password, frst_name FROM customer_login WHERE customerid='" + customerid
							+ "'");
			while (rs.next()) {
				viewCustomer = new CustomerLogin(rs.getInt("customerid"), rs.getNString("email"),
						rs.getNString("password"), rs.getNString("frst_name"));
			}

		} catch (SQLException | ClassNotFoundException | IOException e) {

			e.printStackTrace();
		} finally {
			try {
				if (!rs.isClosed()) {
					rs.close();
				}

				if (!statement.isClosed()) {
					statement.close();
				}
				jDBCStatement.jDBCStatementClose();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return viewCustomer;
	}

}
