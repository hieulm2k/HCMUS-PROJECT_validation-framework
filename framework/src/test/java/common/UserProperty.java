package common;

/**
 * This class used to define all user's property name
 *
 * @author Le Minh Hieu
 * @version 1.0.0
 * @since 1.0.0
 */
public enum UserProperty {
	NAME("name"),
	PHONE_NUMBER("phoneNumber"),
	EMAIL("email"),
	AGE("age");

	private final String property;

	UserProperty(String property) {
		this.property = property;
	}

	/**
	 * Retrieves {@code {@link #property}}
	 *
	 * @return value of {@link #property}
	 */
	public String getProperty() {
		return property;
	}
}
