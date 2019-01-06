package com.moviestore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.moviestore.model.Movies;
import com.moviestore.systemsInterfaces.MoviesDAOI;
import com.moviestore.utility.OracleSQL;

public class MoviesDAO implements MoviesDAOI {

	OracleSQL moviesByID;
	ResultSet rs = null;
	Movies movies;

	/**
	 * @return Movies by moviesID
	 */
	@Override
	public Movies getMoviesByID(int moviesID) {
		moviesByID = new OracleSQL();
		try {
			// rs = emailVCus.getData("SELECT email, password from view_customer WHERE
			// email='"+ email +"'");

			rs = moviesByID.getData(
					"SELECT moviesid, title, description,  TO_CHAR(release_date, 'FMMonth DD, YYYY')as release_date , score, price FROM movies WHERE moviesid = "
							+ moviesID);

			while (rs.next()) {
				movies = new Movies(rs.getInt("moviesid"), rs.getNString("title"), rs.getNString("description"),
						rs.getNString("release_date"), rs.getFloat("score"), rs.getFloat("price"));
			}
			rs.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return movies;
	}

	
	/**
	 * @return List Movies by sql query
	 */
	@Override
	public List<Movies> getMoviesList(String sqlQuery) {
		ResultSet rs = null;
		List<Movies> moviesplu = new ArrayList<Movies>();
		rs = new OracleSQL().getData(sqlQuery);
		try {
			while (rs.next()) {
				moviesplu.add(new Movies(rs.getInt("moviesid"), rs.getNString("title"), rs.getNString("description"),
						rs.getNString("release_date"), rs.getFloat("score"), rs.getFloat("price")));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// moviesplu.clear();
		return moviesplu;

	}

}
