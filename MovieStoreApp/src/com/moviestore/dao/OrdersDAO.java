package com.moviestore.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.moviestore.systemsInterfaces.OrdersDAOI;
import com.moviestore.utility.JDBCStatement;

public class OrdersDAO implements OrdersDAOI{



	@Override
	public boolean insertOrder(int customerID) {
		//String generatedColumns[] = { "CUSTOMERID" };
		JDBCStatement jDBCStatement = new JDBCStatement();
		PreparedStatement stmtInsert = null;

		boolean rz = false;
	
		try {

			stmtInsert = jDBCStatement.getConnection().prepareStatement("INSERT INTO ORDERS (CUSTOMERID) VALUES ("+ customerID+ ")", Statement.RETURN_GENERATED_KEYS);
			stmtInsert.execute();

		
			rz = true;
			

	
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {

				if (!jDBCStatement.getConnection().isClosed()) {
					jDBCStatement.getConnection().close();
				}
				if (!stmtInsert.isClosed()) {
					stmtInsert.close();
				}

			} catch (SQLException | ClassNotFoundException | IOException e) {
			
				e.printStackTrace();
			}
		}

		return rz;
	}

	@Override
	public int getLastID(int customerID) {
		ResultSet rs=null;
		int generatedKey = 0;
		Statement statement = null;
		JDBCStatement jDBCStatement = new JDBCStatement();
		try {
			statement = jDBCStatement.getConnection().createStatement();
			rs = statement.executeQuery("select max(ordersid) as maxid from orders WHERE customerid =" + customerID);
			
			if (rs.next()) {
				generatedKey = rs.getInt("maxid");
			   //generatedKey =(int)  rs.getInt(0);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {

				if (!jDBCStatement.getConnection().isClosed()) {
					jDBCStatement.getConnection().close();
				}
				if (!rs.isClosed()) {
					rs.close();
				}

			} catch (SQLException | ClassNotFoundException | IOException e) {
			
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return generatedKey;
	}

}
