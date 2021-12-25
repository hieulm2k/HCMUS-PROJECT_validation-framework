package validator;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import validator.annotation.IsEmail;
import validator.annotation.IsMobilePhone;
import validator.annotation.IsNotEmpty;
import validator.annotation.IsNotNull;
import validator.annotation.IsNumber;
import validator.annotation.MatchRegexp;
import validator.annotation.MaxLength;
import validator.annotation.MaxValue;
import validator.annotation.MinLength;
import validator.annotation.MinValue;

/**
 * This class used to define all validator types
 *
 * @author Chi Cam Hao
 * @version 1.0.0
 * @since 1.0.0
 */
public enum ValidatorType {
	IS_NOT_EMPTY(IsNotEmpty.class),
	IS_NOT_NULL(IsNotNull.class),
	IS_MOBILE_PHONE(IsMobilePhone.class),
	IS_EMAIL(IsEmail.class),
	IS_NUMBER(IsNumber.class),
	MATCH_REGEXP(MatchRegexp.class),
	MIN_VALUE(MinValue.class),
	MAX_VALUE(MaxValue.class),
	MIN_LENGTH(MinLength.class),
	MAX_LENGTH(MaxLength.class);

	private final Class<? extends Annotation> annotation;

	/**
	 * Parameterized constructor with annotation
	 */
	ValidatorType(Class<? extends Annotation> annotation) {
		this.annotation = annotation;
	}

	/**
	 * Retrieves {@code {@link #annotation}}
	 *
	 * @return value of {@link #annotation}
	 */
	public Class<? extends Annotation> getAnnotation() {
		return annotation;
	}

	/**
	 * This method used to get Validator type by annotation
	 *
	 * @param annotation is the annotation to get validator type
	 * @return Validator type is the type want to get
	 */
	public static ValidatorType getTypeByAnnotation(Class<? extends Annotation> annotation) {
		return Arrays.stream(ValidatorType.values())
				.filter(type -> type.getAnnotation() == annotation)
				.findAny()
				.orElse(null);
	}
}
