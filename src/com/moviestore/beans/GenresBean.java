package com.moviestore.beans;


/**
 * 
 * @author Sasa Budai
 *
 */
public class GenresBean {
	private String genres;

	/**
	 * 
	 */
	public GenresBean() {
		super();
	}

	/**
	 * 
	 * @param genres as String
	 */
	public GenresBean(String genres) {
		super();
		this.genres = genres;
	}

	/**
	 * 
	 * @return genres as String
	 */
	public String getGenres() {
		return genres;
	}

	
	/**
	 * 
	 * @param genres as String
	 */
	public void setGenres(String genres) {
		this.genres = genres;
	}
		
}
