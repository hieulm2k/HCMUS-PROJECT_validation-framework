package facade;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import validator.Validator;
import validator.ValidatorResult;
import validator.ValidatorType;
import validator.factory.ValidatorFactory;

/**
 * This class used to define validation class to communicate with client
 * (Facade pattern + Singleton pattern version Initialization-on-demand holder)
 *
 * @author Tran Thanh Hien
 * @version 1.0.0
 * @since 1.0.0
 */
public class Validation {
	// Static member class member that holds only one instance of the Validation class
	private static class ValidationHolder {
		private static final Validation INSTANCE = new Validation();
	}

	// Validation prevents any other class from instantiating
	private Validation() {
	}

	// Providing Global point of access
	public static Validation getInstance() {
		return ValidationHolder.INSTANCE;
	}

	/**
	 * This class used to validate an object from client
	 *
	 * @param object is the object want to validate
	 * @return Set<ValidatorResult> is the set of results
	 */
	public Set<ValidatorResult> validate(Object object) {
		Set<ValidatorResult> results = new HashSet<>();

		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			Annotation[] annotations = field.getAnnotations();

			for (Annotation annotation : annotations) {
				ValidatorType validatorType = ValidatorType.getTypeByAnnotation(annotation.annotationType());
				if (validatorType != null) {
					Validator validator = ValidatorFactory.createValidator(validatorType);
					if (validator != null) {
						ValidatorResult result = validator.validate(field, object);
						if (!result.isValid()) {
							results.add(result);
						}
					}
				}
			}
		}

		return results;
	}
}
