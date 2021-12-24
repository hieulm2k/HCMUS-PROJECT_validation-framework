package validator.impl;

import java.lang.reflect.Field;

import validator.Validator;
import validator.annotation.IsNotNull;

/**
 * This class used to define is not null validator
 * Check if a string is not null or not
 *
 * @author Vo Van Ba Dat
 * @version 1.0.0
 * @since 1.0.0
 */
public class IsNotNullValidator extends Validator {
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isValid(Field field, Object value) {
		return value != null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getReason(Field field) {
		IsNotNull annotation = field.getDeclaredAnnotation(IsNotNull.class);
		return annotation.message();
	}
}
