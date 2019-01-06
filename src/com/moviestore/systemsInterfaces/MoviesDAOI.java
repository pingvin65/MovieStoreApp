package com.moviestore.systemsInterfaces;

import java.util.List;

import com.moviestore.model.Movies;

public interface MoviesDAOI {

	/**
	 * 
	 * @param moviesID is integer
	 * @return Movie by moviesID
	 */
	public Movies getMoviesByID(int moviesID);
	
	
	/**
	 * 
	 * @param sqlQuery is sql Query as String
	 * @return List of Movies
	 */
	public List<Movies> getMoviesList(String sqlQuery);
	
}
