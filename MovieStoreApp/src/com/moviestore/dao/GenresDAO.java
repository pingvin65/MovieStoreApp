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

		// rs = new OracleSQL().getData("SELECT genres FROM VIEW_MOVIES_HAS_GENRES WHERE
		// mpviesid=" + moviesID);

		try {
			while (rs.next()) { //
				genres.add(new Genres(rs.getNString("genres")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if (!statement.isClosed()) {
				statement.close();
			}
			if (!rs.isClosed()) {
				rs.close();
			}

			if (!jDBCStatement.getConnection().isClosed()) {
				jDBCStatement.getConnection().close();
			}
			} catch (SQLException | ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}finally {
			}
		}

		return genres;
	}

}
