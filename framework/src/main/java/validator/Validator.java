package validator;

import java.lang.reflect.Field;

/**
 * This class used to define all behaviors of validator
 * (Template method pattern: validate() method)
 *
 * @author Le Minh Hieu
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Validator {
	/**
	 * This method used to get value of field from object
	 *
	 * @param field is one field of object fields
	 * @param object is the object want to get
	 * @return Object is the value got from object
	 */
	private Object getValueFromObject(Field field, Object object) {
		try {
			return field.get(object);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * This method used to create a validator result
	 *
	 * @param property is the property want to create
	 * @return ValidatorResult is the result created
	 */
	private ValidatorResult createValidatorResult(String property) {
		ValidatorResult result = new ValidatorResult();

		result.setProperty(property);

		return result;
	}

	/**
	 * This method used to check if value of field is valid or not
	 *
	 * @param field is the field
	 * @return true if valid and vice versa
	 */
	protected abstract boolean isValid(Field field, Object value);

	/**
	 * This method used to get reason why field is invalid
	 *
	 * @param field is the field want to get reason
	 * @return String is the reason
	 */
	protected abstract String getReason(Field field);

	/**
	 * This method used to validate object by field
	 *
	 * @param field is the field of object
	 * @param object is the object want to validate
	 * @return ValidatorResult is the result when validate
	 */
	public final ValidatorResult validate(Field field, Object object) {
		Object value = getValueFromObject(field, object);

		ValidatorResult result = createValidatorResult(field.getName());

		if (!isValid(field, value)) {
			result.setReason(getReason(field));
			result.setValid(false);
		}

		return result;
	}
}
