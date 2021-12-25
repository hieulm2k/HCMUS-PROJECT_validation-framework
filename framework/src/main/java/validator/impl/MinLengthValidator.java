package validator.impl;

import java.lang.reflect.Field;

import validator.Validator;
import validator.annotation.MinLength;

/**
 * This class used to define min length validator
 * Check if the value's length is greater than or equal to the min
 *
 * @author Chi Cam Hao
 * @version 1.0.0
 * @since 1.0.0
 */
public class MinLengthValidator extends Validator {
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isValid(Field field, Object value) {
		MinLength annotation = field.getDeclaredAnnotation(MinLength.class);
		int minLength = annotation.minLength();
		return ((String) value).length() >= minLength;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getReason(Field field) {
		MinLength annotation = field.getDeclaredAnnotation(MinLength.class);
		return annotation.message();
	}
}
