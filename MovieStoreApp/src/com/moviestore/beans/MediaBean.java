package com.moviestore.beans;


/**
 * 
 * @author Sasa Budai
 *
 */
public class MediaBean {
	private int moviesID;
	private String mediaPath;

	public MediaBean(int moviesID, String mediaPath) {
		super();
		this.moviesID = moviesID;
		this.mediaPath = mediaPath;
	}

	/**
	 * Constructor
	 */
	public MediaBean() {
		super();
		
	}

	/**
	 * 
	 * @return  moviesID is int
	 */
	public int getMoviesID() {
		return moviesID;
	}

	
	/**
	 * 
	 * @param moviesID is int
	 */
	public void setMoviesID(int moviesID) {
		this.moviesID = moviesID;
	}

	/**
	 * 
	 * @return String mediaPath
	 */
	public String getMediaPath() {
		return mediaPath;
	}

	/**
	 * 
	 * @param mediaPath String
	 */
	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}

}
