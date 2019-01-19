package com.moviestore.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.moviestore.beans.CustomerFavMovieBeans;
import com.moviestore.systemsInterfaces.CustomerHasOrdersDAOI;
import com.moviestore.utility.JDBCStatement;

public class CustomerHasOrdersDAO implements CustomerHasOrdersDAOI {

	private JDBCStatement jDBCStatement = null;

	

	@Override
	public boolean insertOrder(int ordersID, List<CustomerFavMovieBeans> cusList) {
		String sql = "insert into CUSTOMER_HAS_ORDERS (ORDERSID, MOVIESID, PRICE) values(?, ?, ?)";
		jDBCStatement = new JDBCStatement();
		PreparedStatement ps=null;
		try {
			ps = jDBCStatement.getConnection().prepareStatement(sql);
			
			for (CustomerFavMovieBeans cus : cusList) {
				ps.setInt(1, ordersID);
				ps.setInt(2, cus.getMoviesID());
				ps.setFloat(3, cus.getPrice());
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
			
				if(ps!=null && !ps.isClosed()) {
					
					ps.close();
					
					System.out.println("iiiiiiiiiiiii" +ps.isClosed());
				}
				jDBCStatement.jDBCStatementClose();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
/*		// TODO Auto-generated method stub
		jDBCStatement = new JDBCStatement();
		boolean back= false;
		try {
			//connection = jDBCStatement.getConnection();
			statement = jDBCStatement.getConnection().createStatement();

			for (CustomerFavMovieBeans cus : cusList) {
				String query = "insert into CUSTOMER_HAS_ORDERS (ORDERSID, MOVIESID, PRICE) values('" + ordersID + "','"
						+ cus.getMoviesID() + "','" + cus.getPrice() + "')";
				statement.addBatch(query);
				statement.executeBatch();
				back = true;
			}
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				if (!connection.isClosed()) {
//					connection.close();
//				}
				jDBCStatement.jDBCStatementClose();
				
				if(statement != null && !statement.isClosed()) {
					statement.close();
				}


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return back;
		*/
	}

}
