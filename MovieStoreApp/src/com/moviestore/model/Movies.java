package com.moviestore.model;



public class Movies {
	private int moviesID;
	private String title;
	private String description;
	private String runtime;
	private String releaseDate;
	private float score;
	private int formatID;
	private float price;
	
	
	

	public Movies(int moviesID, String title, String description, String releaseDate, float score, float price) {
		super();
		this.moviesID = moviesID;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.score = score;
		this.price = price;
	}
	public int getMoviesID() {
		return moviesID;
	}
	public void setMoviesID(int moviesID) {
		this.moviesID = moviesID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public float  getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getFormatID() {
		return formatID;
	}
	public void setFormatID(int formatID) {
		this.formatID = formatID;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
