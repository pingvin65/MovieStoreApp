package com.moviestore.dao;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.moviestore.model.Media;
import com.moviestore.systemsInterfaces.MediaDAOI;
import com.moviestore.utility.OracleSQL;

public class MediaDAO implements MediaDAOI {

	@Override
	public List<Media> getMediaByMoviesID(int moviesID) {
		ResultSet rs = null;
		List<Media> medias = new ArrayList<Media>();
		rs = new OracleSQL().getData("SELECT mediatipid, moviesid, mediapath FROM media WHERE moviesid = " + moviesID + " and mediatipid !=1");
		
		try {
			while (rs.next()) { //
				medias.add(new Media(rs.getInt("mediatipid"), rs.getInt("moviesid"), rs.getNString("mediapath")));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return medias;
	}

}
