package model;

import validator.annotation.IsMobilePhone;
import validator.annotation.IsNotEmpty;
import validator.annotation.IsNotNull;

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
}
