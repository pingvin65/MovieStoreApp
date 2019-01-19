package com.moviestore.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.moviestore.model.Movies;
import com.moviestore.systemsInterfaces.MoviesDAOI;
import com.moviestore.utility.JDBCStatement;

public class MoviesDAO implements MoviesDAOI {

	/**
	 * @param int moviesID
	 * @return Movies by moviesID
	 */
	@Override
	public Movies getMoviesByID(int moviesID) {
		JDBCStatement jDBCStatement = null;
		ResultSet rs = null;
		Movies movies = null;
		Statement statement = null;
		jDBCStatement = new JDBCStatement();
		// moviesByID = new OracleSQL();

		try {

			try {
				statement = jDBCStatement.getConnection().createStatement();
				rs = statement.executeQuery(
						"SELECT moviesid, title, description,  TO_CHAR(release_date, 'FMMonth DD, YYYY')as release_date , score, price FROM movies WHERE moviesid ="
								+ moviesID);
			} catch (NullPointerException | ClassNotFoundException | IOException e) {

				e.printStackTrace();
			}

			while (rs.next()) {
				movies = new Movies(rs.getInt("moviesid"), rs.getNString("title"), rs.getNString("description"),
						rs.getNString("release_date"), rs.getFloat("score"), rs.getFloat("price"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				jDBCStatement.jDBCStatementClose();
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (statement != null && !statement.isClosed()) {
					statement.close();
				}

			} catch (NullPointerException | SQLException e) {

				e.printStackTrace();
			}
		}
		return movies;
	}

	/**
	 * @param String sqlQuery
	 * @return List Movies by sql query
	 */
	@Override
	public List<Movies> getMoviesList(String sqlQuery) {
		// JDBCStatement jDBCStatement = new JDBCStatement();
		// moviesByID = new OracleSQL();
		JDBCStatement jDBCStatement = null;

		ResultSet rs = null;
		jDBCStatement = new JDBCStatement();
		Statement statement = null;

		List<Movies> moviesplu = new ArrayList<Movies>();
		try {
			statement = jDBCStatement.getConnection().createStatement();
			rs = statement.executeQuery(sqlQuery);

			while (rs.next()) {
				moviesplu.add(new Movies(rs.getInt("moviesid"), rs.getNString("title"), rs.getNString("description"),
						rs.getNString("release_date"), rs.getFloat("score"), rs.getFloat("price")));
			}

		} catch (NullPointerException | SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				jDBCStatement.jDBCStatementClose();

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (statement != null && !statement.isClosed()) {
					statement.close();
				}

			} catch (NullPointerException | SQLException e) {

				e.printStackTrace();
			}

		}
		return moviesplu;

	}

}
