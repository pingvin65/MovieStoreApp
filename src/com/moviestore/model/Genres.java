package com.moviestore.model;

public class Genres {
	private int moviesID;
	private String genres;
	
	public Genres(int moviesID, String genres) {
		super();
		this.moviesID = moviesID;
		this.genres = genres;
	}

	public Genres(String genres) {
		super();
		this.genres = genres;
	}


	public int getMoviesID() {
		return moviesID;
	}

	public void setMoviesID(int moviesID) {
		this.moviesID = moviesID;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}
	
	
}
