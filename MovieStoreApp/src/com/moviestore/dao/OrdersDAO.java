package com.moviestore.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.moviestore.systemsInterfaces.OrdersDAOI;
import com.moviestore.utility.JDBCStatement;

public class OrdersDAO implements OrdersDAOI {

	/**
	 * @param int customerID
	 * @return boolean if INSERT successful true
	 */
	@Override 
	public boolean insertOrder(int customerID) {
		
		JDBCStatement jDBCStatement = null;
		PreparedStatement stmtInsert = null;
		jDBCStatement = new JDBCStatement();

		boolean rz = false;

		try {

			stmtInsert = jDBCStatement.getConnection().prepareStatement(
					"INSERT INTO ORDERS (CUSTOMERID) VALUES (" + customerID + ")", Statement.RETURN_GENERATED_KEYS);
			stmtInsert.execute();

			rz = true;

		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				if (!stmtInsert.isClosed()) {
					stmtInsert.close();
				}

				jDBCStatement.jDBCStatementClose();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return rz;
	}

	/**
	 * @param int customerID
	 * @return int last generated Key
	 */
	@Override
	public int getLastID(int customerID) {
		ResultSet rs = null;
		int generatedKey = 0;
		Statement statement = null;
		JDBCStatement jDBCStatement = new JDBCStatement();
		try {
			statement = jDBCStatement.getConnection().createStatement();
			rs = statement.executeQuery("select max(ordersid) as maxid from orders WHERE customerid =" + customerID);

			if (rs.next()) {
				generatedKey = rs.getInt("maxid");
				// generatedKey =(int) rs.getInt(0);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
			
				if (!rs.isClosed()) {
					rs.close();
				}
				jDBCStatement.jDBCStatementClose();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	
		return generatedKey;
	}

}
