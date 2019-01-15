package com.moviestore.dao;

import java.util.List;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.moviestore.model.Media;
import com.moviestore.systemsInterfaces.MediaDAOI;
import com.moviestore.utility.JDBCStatement;

public class MediaDAO implements MediaDAOI {



	@Override
	public List<Media> getMediaByMoviesID(int moviesID) {

		List<Media> medias = new ArrayList<Media>();
		JDBCStatement jDBCStatement = null;
		ResultSet rs = null;
		Statement statement = null;

		try {

			jDBCStatement = new JDBCStatement();
			statement = jDBCStatement.getConnection().createStatement();
			rs = statement.executeQuery("SELECT mediatipid, moviesid, mediapath FROM media WHERE moviesid = " + moviesID
					+ " and mediatipid !=1");
			// rs = new OracleSQL().getData("SELECT mediatipid, moviesid, mediapath FROM
			// media WHERE moviesid = " + moviesID + " and mediatipid !=1");
			while (rs.next()) { //
				medias.add(new Media(rs.getInt("mediatipid"), rs.getInt("moviesid"), rs.getNString("mediapath")));
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
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
			} finally {
			}
		}

		return medias;
	}

}
