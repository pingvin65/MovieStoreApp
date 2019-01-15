package com.moviestore.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Sasa Budai
 *
 */
public class UserBean {
	@NotNull
	@Email(message = "Please enter a well-formed email address")
	private String email;

	@Size(min = 6, max = 15, message = "Your password must between {2} and {1} characters.")
	@NotNull(message = "Please select a password")
	private String password;
	private String logged;

	@Size(min = 2, max = 32, message = "Your name must between {2} and {1} characters.")
	private String frstName;
	@NotNull
	@Size(min = 2, max = 32, message = "Your name must between {2} and {1} characters.")
	private String lastName;

	@NotNull
	private String password2;

	/**
	 * 
	 * @param email as String
	 * @param password as String
	 * @param logged as String
	 * @param frstName as String
	 * @param lastName as String
	 * @param password2 as String
	 */
	public UserBean(@NotNull String email, String password, String logged, String frstName, String lastName,
			@NotNull String password2) {
		super();
		this.email = email;
		this.password = password;
		this.logged = logged;
		this.frstName = frstName;
		this.lastName = lastName;
		this.password2 = password2;
	}

	
	/**
	 * 
	 */
	public UserBean() {
		super();

	}

	
	/**
	 * 
	 * @param email as String
	 * @param password as String
	 */
	public UserBean(@NotNull String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	
	/**
	 * 
	 * @return logged as String
	 */
	public String getLogged() {
		return logged;
	}

	
	/**
	 * 
	 * @param logged as String
	 */
	public void setLogged(String logged) {
		this.logged = logged;
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
	 * @return password as String
	 */
	public String getPassword() {
		return password;
	}

	
	/**
	 * 
	 * @param  password as String
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	/**
	 * @return frstName as String
	 */
	public String getFrstName() {
		return frstName;
	}

	
	/**
	 * 
	 * @param frstName as String
	 */
	public void setFrstName(String frstName) {
		this.frstName = frstName;
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
	 * @return password2 as String
	 */
	public String getPassword2() {
		return password2;
	}

	
	/**
	 * 
	 * @param password2 as String
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
