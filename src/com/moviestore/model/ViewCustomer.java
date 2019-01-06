package com.moviestore.model;

public class ViewCustomer {

	private String username;
	private String email;
	private String street;
	private String apt;
	private String cityname;
	private String password;
	private int zipcode;
	private String stateName;
	private String firstName;
	private String lastName;
	private String createDate;

	/**
	 * 
	 * @param email as String
	 * @param password as String
	 */
	public ViewCustomer(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	/**
	 * 
	 * @return username sa String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username as String
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @return email as String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email as String
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return street as String
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * 
	 * @param street as String
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * 
	 * @return apt (apartman) as String
	 */
	public String getApt() {
		return apt;
	}

	/**
	 * 
	 * @param apt (apartman) as String
	 */
	public void setApt(String apt) {
		this.apt = apt;
	}

	/**
	 * 
	 * @return cityname as String
	 */
	public String getCityname() {
		return cityname;
	}

	/**
	 * 
	 * @param cityname as String
	 */
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	/**
	 * 
	 * @return password as String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password as String
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return zip code as integer
	 */
	public int getZipcode() {
		return zipcode;
	}

	/**
	 * 
	 * @param zipcode as integer
	 */
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * 
	 * @return stateName as String
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * 
	 * @param stateName as String
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * 
	 * @return firstName as String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName as String
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return lastName as String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName as String
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return createDate as String
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 
	 * @param createDate as String
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
