package com.moviestore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.moviestore.model.PersonRolesInMovies;
import com.moviestore.systemsInterfaces.PersonRolesInMoviesDAOI;
import com.moviestore.utility.OracleSQL;


/**
 * 
 * @author Sasa Budai
 *
 */
public class PersonRolesInMoviesDAO implements PersonRolesInMoviesDAOI {

	/**
	 * @return List Perso nRoles In Movies by movieID
	 */
	@Override
	public List<PersonRolesInMovies> getPersonRolesInMoviesByMovieID(int movieID) {
		ResultSet rs = null;
		List<PersonRolesInMovies> personRolesInMovies = new ArrayList<PersonRolesInMovies>();
		rs = new OracleSQL().getData(
				"SELECT person_fname, person_lname, orderinmovies, roulesid, movieid FROM VIEW_PERSON_ROLES_IN_MOVIES WHERE movieid="
						+ movieID + " ORDER BY roulesid ASC, orderinmovies ASC");
		try {
			while (rs.next()) { //
				personRolesInMovies
						.add(new PersonRolesInMovies(rs.getNString("person_fname"), rs.getNString("person_lname"),
								rs.getInt("orderinmovies"), rs.getInt("roulesid"), rs.getInt("movieid")));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personRolesInMovies;
	}
}
