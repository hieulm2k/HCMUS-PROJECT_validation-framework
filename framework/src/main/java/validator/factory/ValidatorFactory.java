package validator.factory;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import validator.Validator;
import validator.ValidatorType;
import validator.impl.IsEmailValidator;
import validator.impl.IsMobilePhoneValidator;
import validator.impl.IsNotEmptyValidator;
import validator.impl.IsNotNullValidator;
import validator.impl.IsNumberValidator;
import validator.impl.MatchRegexpValidator;
import validator.impl.MaxValueValidator;
import validator.impl.MinValueValidator;

/**
 * This class used to define validator factory
 * (Factory pattern)
 *
 * @author Vo Van Ba Dat
 * @version 1.0.0
 * @since 1.0.0
 */
public class ValidatorFactory {
	private static final Map<Class<? extends Annotation>, Validator> validatorMap = new HashMap<>();

	// Validator factory prevents any other class from instantiating
	private ValidatorFactory() {
	}

	/**
	 * This method use to create validator by type
	 *
	 * @param validatorType is the type of validator want to create
	 * @return Validator want to create
	 */
	public static Validator createValidator(ValidatorType validatorType) {
		Validator validator = validatorMap.get(validatorType.getAnnotation());

		if (validator == null) {
			switch (validatorType) {
				case IS_NOT_EMPTY:
					validator = new IsNotEmptyValidator();
					break;
				case IS_NOT_NULL:
					validator = new IsNotNullValidator();
					break;
				case IS_MOBILE_PHONE:
					validator = new IsMobilePhoneValidator();
					break;
				case IS_EMAIL:
					validator = new IsEmailValidator();
					break;
				case IS_NUMBER:
					validator = new IsNumberValidator();
					break;
				case MATCH_REGEXP:
					validator = new MatchRegexpValidator();
					break;
				case MIN_VALUE:
					validator = new MinValueValidator();
					break;
				case MAX_VALUE:
					validator = new MaxValueValidator();
					break;
				default:
					return null;
			}
			validatorMap.put(validatorType.getAnnotation(), validator);
		}

		return validator;
	}
}
