package validator.impl;

import java.lang.reflect.Field;
import java.util.Objects;

import common.Constant;
import validator.Validator;
import validator.annotation.IsNotEmpty;

/**
 * This class used to define is not empty validator
 * Check if a string is not empty or not
 *
 * @author Le Minh Hieu
 * @version 1.0.0
 * @since 1.0.0
 */
public class IsNotEmptyValidator extends Validator {
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isValid(Field field, Object value) {
		return !Objects.equals(String.valueOf(value).trim(), Constant.NONE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getReason(Field field) {
		IsNotEmpty annotation = field.getDeclaredAnnotation(IsNotEmpty.class);
		return annotation.message();
	}
}
