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
	
	//OracleSQL moviesByID;
	ResultSet rs = null;
	Movies movies;
	Statement statement = null;

	/**
	 * @return Movies by moviesID
	 */
	@Override
	public Movies getMoviesByID(int moviesID) {
		JDBCStatement jDBCStatement = new JDBCStatement();
		// moviesByID = new OracleSQL();
		
		try {
			// rs = emailVCus.getData("SELECT email, password from view_customer WHERE
			// email='"+ email +"'");
			// jDBCStatement.getConnection();
			try {
				statement = null;
				statement = jDBCStatement.getConnection().createStatement();
				rs = statement.executeQuery(
						"SELECT moviesid, title, description,  TO_CHAR(release_date, 'FMMonth DD, YYYY')as release_date , score, price FROM movies WHERE moviesid =" + moviesID);
			} catch (ClassNotFoundException | IOException e) {
			
				e.printStackTrace();
			}

//			rs = moviesByID.getData(
//					"SELECT moviesid, title, description,  TO_CHAR(release_date, 'FMMonth DD, YYYY')as release_date , score, price FROM movies WHERE moviesid = "
//							+ moviesID);

			while (rs.next()) {
				movies = new Movies(rs.getInt("moviesid"), rs.getNString("title"), rs.getNString("description"),
						rs.getNString("release_date"), rs.getFloat("score"), rs.getFloat("price"));
			}

		
		} catch (SQLException e) {
			System.out.println("ssssssssssssssssssssssssssssssssssss");
			e.printStackTrace();
		}finally {
			try {
				if (!rs.isClosed()) {
					rs.close();
				}
				if (!jDBCStatement.getConnection().isClosed()) {
					jDBCStatement.getConnection().close();
				}
				if (!statement.isClosed()) {
					statement.close();
				}
			} catch (SQLException | ClassNotFoundException | IOException e) {
			
				e.printStackTrace();
			}
		}
		return movies;
	}

	/**
	 * @return List Movies by sql query
	 */
	@Override
	public List<Movies> getMoviesList(String sqlQuery) {
		JDBCStatement jDBCStatement = new JDBCStatement();
		// moviesByID = new OracleSQL();
		ResultSet rs = null;
		List<Movies> moviesplu = new ArrayList<Movies>();
		try {
			statement = null;
			statement = jDBCStatement.getConnection().createStatement();
			rs = statement.executeQuery(sqlQuery);
		} catch (ClassNotFoundException | SQLException | IOException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}

		// rs = new OracleSQL().getData(sqlQuery);
		try {
			while (rs.next()) {
				moviesplu.add(new Movies(rs.getInt("moviesid"), rs.getNString("title"), rs.getNString("description"),
						rs.getNString("release_date"), rs.getFloat("score"), rs.getFloat("price")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (!rs.isClosed()) {
					rs.close();
				}
				if (!jDBCStatement.getConnection().isClosed()) {
					jDBCStatement.getConnection().close();
				}
				if (!statement.isClosed()) {
					statement.close();
				}
			} catch (SQLException | ClassNotFoundException | IOException e) {
			
				e.printStackTrace();
			}

			
		}
		// moviesplu.clear();
		return moviesplu;

	}

}
