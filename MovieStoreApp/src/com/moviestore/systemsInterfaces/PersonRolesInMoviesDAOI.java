package com.moviestore.systemsInterfaces;

import java.util.List;

import com.moviestore.model.PersonRolesInMovies;

public interface PersonRolesInMoviesDAOI {
		public List<PersonRolesInMovies> getPersonRolesInMoviesByMovieID(int movieID);
}
