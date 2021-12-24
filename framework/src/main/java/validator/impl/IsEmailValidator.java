package validator.impl;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

import validator.Validator;
import validator.annotation.IsEmail;

/**
 * This class used to define email validator
 * Check if an email is valid or not
 *
 * @author Tran Thanh Hien
 * @version 1.0.0
 * @since 1.0.0
 */
public class IsEmailValidator extends Validator {
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isValid(Field field, Object value) {
		String emailPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

		Pattern regex = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		return regex.matcher((CharSequence) value).find();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getReason(Field field) {
		IsEmail annotation = field.getDeclaredAnnotation(IsEmail.class);
		return annotation.message();
	}
}
