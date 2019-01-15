package com.moviestore.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.moviestore.model.CustomerFavMovie;
import com.moviestore.systemsInterfaces.CustomerFavMovieDAOI;
import com.moviestore.utility.JDBCStatement;


public class CustomerFavMovieDAO implements CustomerFavMovieDAOI{

	private JDBCStatement jDBCStatement;
	
	
	
	@Override
	public List<CustomerFavMovie> favouriteMovie(int customerID, String table) {
		
		
		ResultSet rs = null;
		List<CustomerFavMovie> cufaMoviep = new ArrayList<CustomerFavMovie>();
		Statement statement = null;
		try {
			
			jDBCStatement = new JDBCStatement();
			statement = jDBCStatement.getConnection().createStatement();
			rs = statement.executeQuery("SELECT consumerfmid, moviesid, customerid, runtime, title, price, score FROM "+ table +" WHERE customerid=" + customerID);
			while (rs.next()) { //CustomerFavMovie(int moviesID, int runtime, String title, float price, float score)
				cufaMoviep.add(new CustomerFavMovie(rs.getInt("consumerfmid"), rs.getInt("moviesid"), rs.getInt("customerid"), rs.getInt("runtime"), rs.getNString("title"), rs.getFloat("price"), rs.getFloat("score")));
			}
			

		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}finally {
			try {
			if (!statement.isClosed()) {
				statement.close();
			}
			if (!rs.isClosed()) {
				rs.close();
			}

			if (!jDBCStatement.getConnection().isClosed()) {
				jDBCStatement.getConnection().close();
			}
			} catch (SQLException | ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}finally {
			}
		}
		return cufaMoviep;
	}
	
	@Override
	public boolean inserData(String sql) {
		boolean created = false;
		PreparedStatement preparedStatement =null;
		try {
			jDBCStatement = new JDBCStatement();
			preparedStatement = jDBCStatement.getConnection().prepareStatement(sql);
			//ps.execute();
			preparedStatement.executeUpdate();
			created = true;

		} catch (ClassNotFoundException | SQLException | IOException e) {

			e.printStackTrace();
		} finally {
			
			try {
				if (preparedStatement != null) {
				preparedStatement.close();
				}
				if (jDBCStatement.getConnection() != null) {
					jDBCStatement.getConnection().close();
				}
			} catch (SQLException | ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		

	}

		return created;

	}

	@Override
	public boolean deleteRecordFromTable(String sql) {
		boolean exute = false;
		PreparedStatement preparedStatement = null;
		
		
		try {
			jDBCStatement = new JDBCStatement();

			preparedStatement = jDBCStatement.getConnection().prepareStatement(sql);

			preparedStatement.executeUpdate();

			exute = true;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if (preparedStatement != null) {
					preparedStatement.close();
					}
					if (jDBCStatement.getConnection() != null) {
						jDBCStatement.getConnection().close();
					}
				} catch (SQLException | ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

			

		}
		
		return exute;
	}

}
