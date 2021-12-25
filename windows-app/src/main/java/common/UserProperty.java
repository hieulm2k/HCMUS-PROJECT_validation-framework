package common;

import java.util.Arrays;
import java.util.Objects;

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
	AGE("age"),
	PASSWORD("password"),
	ADDRESS("address");

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

	/**
	 * This method used to get user property by name
	 *
	 * @param name is name want to get property
	 * @return UserProperty want to get
	 */
	public static UserProperty getPropertyByName(String name) {
		return Arrays.stream(UserProperty.values())
				.filter(property -> Objects.equals(property.getProperty(), name))
				.findAny()
				.orElse(null);
	}
}
