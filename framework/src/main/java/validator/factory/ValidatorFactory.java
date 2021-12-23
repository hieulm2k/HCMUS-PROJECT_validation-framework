package validator.factory;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import validator.Validator;
import validator.ValidatorType;

/**
 * This class used to define validator factory
 *
 * @author Vo Van Ba Dat
 * @version 1.0.0
 * @since 1.0.0
 */
public class ValidatorFactory {
	private static final Map<Class<? extends Annotation>, Validator> validatorMap = new HashMap<>();

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
				default:
					return null;
			}
//				validatorMap.put(validatorType.getAnnotation(), validator);
		}

		return validator;
	}
}
