package com.moviestore.beans;



/**
 * @author Sasa Budai
 *
 */
public class MoviesBean {
	private int moviesID;
	private String title;
	private String description;
	private String releaseDate;
	private float score;
	private float price;
	private String picture;
	private String mediaPath;

	public MoviesBean() {
		super();

	}

	/**
	 * 
	 * @param title as String
	 * @param description  as String
	 * @param releaseDate as String
	 * @param score as float
	 * @param price as float
	 */
	public MoviesBean(String title, String description, String releaseDate, float score, float price) {
		super();
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.score = score;
		this.price = price;
	}

	/**
	 * 
	 * @param moviesID as int
	 * @param title as String
	 * @param description as String
	 * @param releaseDate as String
	 * @param score as float
	 * @param price as float
	 * @param picture as String
	 */
	public MoviesBean(int moviesID, String title, String description, String releaseDate, float score, float price,
			String picture) {
		super();
		this.moviesID = moviesID;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.score = score;
		this.price = price;
		this.picture = picture;
	}

	/**
	 * 
	 * @param moviesID as int
	 * @param title as String
	 * @param description as String
	 * @param releaseDate as String
	 * @param score as float
	 * @param price as float
	 * @param picture as String
	 * @param mediaPath as String
	 */
	public MoviesBean(int moviesID, String title, String description, String releaseDate, float score, float price,
			String picture, String mediaPath) {
		super();
		this.moviesID = moviesID;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.score = score;
		this.price = price;
		this.picture = picture;
		this.mediaPath = mediaPath;
	}

	
	/**
	 * 
	 * @return moviesID as Integer
	 */
	public int getMoviesID() {
		return moviesID;
	}

	
	/**
	 * 
	 * @param moviesID as int
	 */
	public void setMoviesID(int moviesID) {
		this.moviesID = moviesID;
	}

	/**
	 * 
	 * @return picture as String
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * 
	 * @param  picture as String 
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	
	/**
	 * 
	 * @return title as String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title as String
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return description as String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description as String
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/**
	 * 
	 * @return releaseDate as String
	 */
	public String getReleaseDate() {
		return releaseDate;
	}

	
	/**
	 * @param releaseDate as String
	 */
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	
	/**
	 * 
	 * @return score as float
	 */
	public float getScore() {
		return score;
	}

	
	/**
	 * 
	 * @param score as float
	 */
	public void setScore(float score) {
		this.score = score;
	}

	/**
	 * 
	 * @return price as float
	 */
	public float getPrice() {
		return price;
	}

	
	/**
	 * 
	 * @param price as float
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	
	/**
	 * 
	 * @return mediaPath as String
	 */
	public String getMediaPath() {
		return mediaPath;
	}

	
	/**
	 * 
	 * @param mediaPath as String
	 */
	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}

}
