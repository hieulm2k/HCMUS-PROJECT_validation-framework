package validator;

/**
 * This class used to define validator result
 *
 * @author Le Minh Hieu
 * @version 1.0.0
 * @since 1.0.0
 */
public class ValidatorResult {
	private String reason;
	private String property;
	private boolean valid;

	/**
	 * Retrieves {@code {@link #reason}}
	 *
	 * @return value of {@link #reason}
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * Sets {@code reason}
	 *
	 * @param reason the {@code java.lang.String} field
	 */
	public void setReason(String reason) {
		this.reason = reason;
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
	 * Sets {@code property}
	 *
	 * @param property the {@code java.lang.String} field
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * Retrieves {@code {@link #valid}}
	 *
	 * @return value of {@link #valid}
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * Sets {@code valid}
	 *
	 * @param valid the {@code boolean} field
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
