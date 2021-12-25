package validator.impl;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

import validator.Validator;
import validator.annotation.MatchRegexp;

/**
 * This class used to define match regular expression validator
 * Check if a value can match a regular expression or not
 *
 * @author Le Minh Hieu
 * @version 1.0.0
 * @since 1.0.0
 */
public class MatchRegexpValidator extends Validator {
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isValid(Field field, Object value) {
		MatchRegexp annotation = field.getDeclaredAnnotation(MatchRegexp.class);
		String pattern = annotation.pattern();
		Pattern regex = Pattern.compile(pattern);
		return regex.matcher((CharSequence) value).find();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getReason(Field field) {
		MatchRegexp annotation = field.getDeclaredAnnotation(MatchRegexp.class);
		return annotation.message();
	}
}
