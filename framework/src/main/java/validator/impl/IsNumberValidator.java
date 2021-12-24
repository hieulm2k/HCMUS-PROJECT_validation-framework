package validator.impl;

import java.lang.reflect.Field;

import validator.Validator;
import validator.annotation.IsNumber;

/**
 * This class used to define is number validator
 * Check if a value can safely be converted to a number or not
 *
 * @author Le Minh Hieu
 * @version 1.0.0
 * @since 1.0.0
 */
public class IsNumberValidator extends Validator {
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isValid(Field field, Object value) {
		String number = (String) value;

		if (number == null) {
			return false;
		}

		try {
			Double.parseDouble(number);
		} catch (NumberFormatException nfe) {
			return false;
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getReason(Field field) {
		IsNumber annotation = field.getDeclaredAnnotation(IsNumber.class);
		return annotation.message();
	}
}
