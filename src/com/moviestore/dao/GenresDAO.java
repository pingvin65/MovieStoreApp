package com.moviestore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.moviestore.model.Genres;
import com.moviestore.systemsInterfaces.GenresDAOI;
import com.moviestore.utility.OracleSQL;


/**
 * 
 * @author Sasa Budai
 *
 */
public class GenresDAO implements GenresDAOI{

	/**
	 * @return List genres by movieID
	 */
	@Override
	public List<Genres> getGenres(int moviesID) {
		ResultSet rs = null;
		List<Genres> genres = new ArrayList<Genres>();
		rs = new OracleSQL().getData("SELECT genres FROM VIEW_MOVIES_HAS_GENRES WHERE mpviesid=" + moviesID);
		
		try {
			while (rs.next()) { //
				genres.add(new Genres(rs.getNString("genres")));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return genres;
	}


}
