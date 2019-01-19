package com.moviestore.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.moviestore.model.PersonRolesInMovies;
import com.moviestore.systemsInterfaces.PersonRolesInMoviesDAOI;
import com.moviestore.utility.JDBCStatement;

/**
 * 
 * @author Sasa Budai
 *
 */
public class PersonRolesInMoviesDAO implements PersonRolesInMoviesDAOI {

	JDBCStatement jDBCStatement;
	ResultSet rs = null;
	Statement statement = null;

	/**
	 * 
	 * @param int movieID
	 * @return List Perso nRoles In Movies by movieID
	 */
	@Override
	public List<PersonRolesInMovies> getPersonRolesInMoviesByMovieID(int movieID) {
		jDBCStatement = new JDBCStatement();
		List<PersonRolesInMovies> personRolesInMovies = new ArrayList<PersonRolesInMovies>();

		try {

			statement = jDBCStatement.getConnection().createStatement();
			rs = statement.executeQuery(
					"SELECT person_fname, person_lname, orderinmovies, roulesid, movieid FROM VIEW_PERSON_ROLES_IN_MOVIES WHERE movieid="
							+ movieID + " ORDER BY roulesid ASC, orderinmovies ASC");

			while (rs.next()) { //
				personRolesInMovies
						.add(new PersonRolesInMovies(rs.getNString("person_fname"), rs.getNString("person_lname"),
								rs.getInt("orderinmovies"), rs.getInt("roulesid"), rs.getInt("movieid")));
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				jDBCStatement.jDBCStatementClose();

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (statement != null && statement.isClosed()) {
					statement.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personRolesInMovies;
	}
}
