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

public class CustomerFavMovieDAO implements CustomerFavMovieDAOI {

	private JDBCStatement jDBCStatement;

	/**
	 * @param int customerID
	 * @param String table, name of sql table
	 * @return List CustomerFavMovie
	 */
	@Override
	public List<CustomerFavMovie> favouriteMovie(int customerID, String table) {

		ResultSet rs = null;
		List<CustomerFavMovie> cufaMoviep = new ArrayList<CustomerFavMovie>();
		Statement statement = null;
		try {

			jDBCStatement = new JDBCStatement();
			statement = jDBCStatement.getConnection().createStatement();
			rs = statement.executeQuery("SELECT consumerfmid, moviesid, customerid, runtime, title, price, score FROM "
					+ table + " WHERE customerid=" + customerID);
			while (rs.next()) { // CustomerFavMovie(int moviesID, int runtime, String title, float price, float
								// score)
				cufaMoviep.add(new CustomerFavMovie(rs.getInt("consumerfmid"), rs.getInt("moviesid"),
						rs.getInt("customerid"), rs.getInt("runtime"), rs.getNString("title"), rs.getFloat("price"),
						rs.getFloat("score")));
			}

		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				jDBCStatement.jDBCStatementClose();
				
				if (!statement.isClosed()) {
					statement.close();
				}
				if (!rs.isClosed()) {
					rs.close();
				}
			

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			}
		}
		return cufaMoviep;
	}

	/**
	 * @param String sql
	 * @return boolean true if is successful
	 */
	@Override
	public boolean inserData(String sql) {
		boolean created = false;
		PreparedStatement preparedStatement = null;
		try {
			jDBCStatement = new JDBCStatement();
			preparedStatement = jDBCStatement.getConnection().prepareStatement(sql);
			// ps.execute();
			preparedStatement.executeUpdate();
			created = true;

		} catch (ClassNotFoundException | SQLException | IOException e) {

			e.printStackTrace();
		} finally {

			try {
				jDBCStatement.jDBCStatementClose();
				if (preparedStatement != null && preparedStatement.isClosed()) {
					preparedStatement.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return created;

	}

	/**
	 * @param String sql
	 * @return boolean true if is successful
	 */
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
			e.printStackTrace();
		} finally {

			try {
				jDBCStatement.jDBCStatementClose();
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return exute;
	}

}
