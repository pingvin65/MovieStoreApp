package com.moviestore.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.moviestore.model.Genres;
import com.moviestore.systemsInterfaces.GenresDAOI;
import com.moviestore.utility.JDBCStatement;

/**
 * 
 * @author Sasa Budai
 *
 */
public class GenresDAO implements GenresDAOI {

	private JDBCStatement jDBCStatement;
	private ResultSet rs = null;

	/**
	 * @param int moviesID
	 * @return List genres by movieID
	 */
	@Override
	public List<Genres> getGenres(int moviesID) {

		Statement statement = null;

		List<Genres> genres = new ArrayList<Genres>();

		try {
			jDBCStatement = new JDBCStatement();
			statement = jDBCStatement.getConnection().createStatement();
			rs = statement.executeQuery("SELECT genres FROM VIEW_MOVIES_HAS_GENRES WHERE mpviesid=" + moviesID);
		} catch (ClassNotFoundException | SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		try {
			while (rs.next()) { //
				genres.add(new Genres(rs.getNString("genres")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs !=null && !rs.isClosed()) {
					rs.close();
				}
				if (statement != null && !statement.isClosed()) {
					statement.close();
				}

				jDBCStatement.jDBCStatementClose();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			}
		}

		return genres;
	}

}
