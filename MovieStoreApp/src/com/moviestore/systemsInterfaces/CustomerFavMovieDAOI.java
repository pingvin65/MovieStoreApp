package com.moviestore.systemsInterfaces;

import java.util.List;

import com.moviestore.model.CustomerFavMovie;

public interface CustomerFavMovieDAOI {

	public List<CustomerFavMovie> favouriteMovie(int customerID, String table);

	public boolean inserData(String sql);

	public boolean deleteRecordFromTable(String sql);

}
