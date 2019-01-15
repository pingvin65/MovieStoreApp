package com.moviestore.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.moviestore.beans.CustomerFavMovieBeans;
import com.moviestore.systemsInterfaces.CustomerHasOrdersDAOI;
import com.moviestore.utility.JDBCStatement;

public class CustomerHasOrdersDAO implements CustomerHasOrdersDAOI{

	@Override
	public boolean insertOrder (int ordersID, List<CustomerFavMovieBeans> cusList){
		// TODO Auto-generated method stub
		JDBCStatement jDBCStatement = new JDBCStatement();
		Connection connection = null;
		try {
			connection = jDBCStatement.getConnection();
			Statement statement = connection.createStatement();

			for (CustomerFavMovieBeans cus: cusList) {
				String query = "insert into CUSTOMER_HAS_ORDERS (ORDERSID, MOVIESID, PRICE) values('"
						+ ordersID + "','" + cus.getMoviesID()+ "','" + cus.getPrice() +"')";
				statement.addBatch(query);
				statement.executeBatch();
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(!connection.isClosed()) {
					connection.close();
				}
				if(!jDBCStatement.getConnection().isClosed()) {
					jDBCStatement.getConnection().close();
				}
			} catch (SQLException | ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	
		return false;
	}

}
