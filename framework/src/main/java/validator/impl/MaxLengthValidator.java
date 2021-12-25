package validator.impl;

import java.lang.reflect.Field;

import validator.Validator;
import validator.annotation.MaxLength;

/**
 * This class used to define max length validator
 * Check if the value's length is less than or equal to the max
 *
 * @author Vo Van Ba Dat
 * @version 1.0.0
 * @since 1.0.0
 */
public class MaxLengthValidator extends Validator {
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isValid(Field field, Object value) {
		MaxLength annotation = field.getDeclaredAnnotation(MaxLength.class);
		int maxLength = annotation.maxLength();
		return ((String) value).length() <= maxLength;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getReason(Field field) {
		MaxLength annotation = field.getDeclaredAnnotation(MaxLength.class);
		return annotation.message();
	}
}
