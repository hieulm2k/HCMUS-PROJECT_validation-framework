package validator.impl;

import java.lang.reflect.Field;

import validator.Validator;
import validator.annotation.MinValue;

/**
 * This class used to define min value validator
 * Check if a value is greater than or equal to the min
 *
 * @author Vo Van Ba Dat
 * @version 1.0.0
 * @since 1.0.0
 */
public class MinValueValidator extends Validator {
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isValid(Field field, Object value) {
		MinValue annotation = field.getDeclaredAnnotation(MinValue.class);
		double minValue = annotation.min();

		String number = (String) value;

		if (number == null) {
			return false;
		}

		try {
			double num = Double.parseDouble(number);
			if (num < minValue) {
				return false;
			}
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
		MinValue annotation = field.getDeclaredAnnotation(MinValue.class);
		return annotation.message();
	}
}
