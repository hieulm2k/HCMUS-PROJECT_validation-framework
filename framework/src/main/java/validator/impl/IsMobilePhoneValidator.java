package validator.impl;

import java.lang.reflect.Field;

import validator.Validator;
import validator.annotation.IsMobilePhone;

/**
 * This class used to define mobile phone validator
 * Check if a mobile phone is valid or not
 *
 * @author Chi Cam Hao
 * @version 1.0.0
 * @since 1.0.0
 */
public class IsMobilePhoneValidator extends Validator {
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isValid(Field field, Object value) {
		String mobilePhone = (String) value;
		// Length of mobile phone must be 10
		if (mobilePhone.length() != 10) {
			return false;
		}

		// Check each char is a digit or not, if not -> wrong format
		for (int i = 0; i < mobilePhone.length(); i++) {
			if (!Character.isDigit(mobilePhone.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getReason(Field field) {
		IsMobilePhone annotation = field.getDeclaredAnnotation(IsMobilePhone.class);
		return annotation.message();
	}
}
