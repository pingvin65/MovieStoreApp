package com.moviestore.systemsInterfaces;

import java.util.List;

import com.moviestore.model.Genres;

public interface GenresDAOI {

	public List<Genres> getGenres(int moviesID);
}
