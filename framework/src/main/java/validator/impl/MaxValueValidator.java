package validator.impl;

import java.lang.reflect.Field;

import validator.Validator;
import validator.annotation.MaxValue;

/**
 * This class used to define max value validator
 * Check if a value is less than or equal to the max
 *
 * @author Tran Thanh Hien
 * @version 1.0.0
 * @since 1.0.0
 */
public class MaxValueValidator extends Validator {
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isValid(Field field, Object value) {
		MaxValue annotation = field.getDeclaredAnnotation(MaxValue.class);
		double maxValue = annotation.max();

		if (value == null) {
			return false;
		}

		try {
			double num = Double.parseDouble((String) value);
			if (num > maxValue) {
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
		MaxValue annotation = field.getDeclaredAnnotation(MaxValue.class);
		return annotation.message();
	}
}
