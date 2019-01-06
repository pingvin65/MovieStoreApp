package com.moviestore.model;

public class Media {
	private int mediaID;
	private int mediatipID;
	private int moviesID;
	private String mediaPath;

	public Media(int mediatipID, int moviesID, String mediaPath) {
		super();
		this.mediatipID = mediatipID;
		this.moviesID = moviesID;
		this.mediaPath = mediaPath;
	}

	public int getMediaID() {
		return mediaID;
	}

	public void setMediaID(int mediaID) {
		this.mediaID = mediaID;
	}

	public int getMediatipID() {
		return mediatipID;
	}

	public void setMediatipID(int mediatipID) {
		this.mediatipID = mediatipID;
	}

	public int getMoviesID() {
		return moviesID;
	}

	public void setMoviesID(int moviesID) {
		this.moviesID = moviesID;
	}

	public String getMediaPath() {
		return mediaPath;
	}

	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}



}
