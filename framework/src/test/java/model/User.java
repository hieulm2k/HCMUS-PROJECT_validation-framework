package model;

import validator.annotation.IsEmail;
import validator.annotation.IsMobilePhone;
import validator.annotation.IsNotEmpty;
import validator.annotation.IsNotNull;
import validator.annotation.IsNumber;
import validator.annotation.MatchRegexp;
import validator.annotation.MinValue;

/**
 * This class used to define a user model for testing
 *
 * @author Le Minh Hieu
 * @version 1.0.0
 * @since 1.0.0
 */
public class User {
	@IsNotEmpty
	@IsNotNull
	private String name;

	@IsMobilePhone
	private String phoneNumber;

	@IsEmail
	private String email;

	@IsNumber
	@MinValue(min = 6)
	private String age;

	@MatchRegexp(
			pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
			message = "Password is too weak")
	private String password;

	/**
	 * Retrieves {@code {@link #name}}
	 *
	 * @return value of {@link #name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets {@code name}
	 *
	 * @param name the {@code java.lang.String} field
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves {@code {@link #phoneNumber}}
	 *
	 * @return value of {@link #phoneNumber}
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets {@code phoneNumber}
	 *
	 * @param phoneNumber the {@code java.lang.String} field
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Retrieves {@code {@link #email}}
	 *
	 * @return value of {@link #email}
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets {@code email}
	 *
	 * @param email the {@code java.lang.String} field
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retrieves {@code {@link #age}}
	 *
	 * @return value of {@link #age}
	 */
	public String getAge() {
		return age;
	}

	/**
	 * Sets {@code age}
	 *
	 * @param age the {@code java.lang.String} field
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * Retrieves {@code {@link #password}}
	 *
	 * @return value of {@link #password}
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets {@code password}
	 *
	 * @param password the {@code java.lang.String} field
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
