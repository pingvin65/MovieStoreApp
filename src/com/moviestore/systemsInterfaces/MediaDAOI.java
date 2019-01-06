package com.moviestore.systemsInterfaces;

import java.util.List;

import com.moviestore.model.Media;

public interface MediaDAOI {

	public List<Media> getMediaByMoviesID(int moviesID);
}
