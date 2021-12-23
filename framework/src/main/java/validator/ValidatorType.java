package validator;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * This class used to define all validator types
 *
 * @author Chi Cam Hao
 * @version 1.0.0
 * @since 1.0.0
 */
public enum ValidatorType {
	;
	private final Class<? extends Annotation> annotation;

	/**
	 * Parameterized constructor with annotation
	 * @param annotation
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
	 * @param annotation is the annotation to get validator type
	 * @return Validator type is the type want to get
	 */
	public static ValidatorType getValidatorByAnnotation(Class<? extends Annotation> annotation) {
		return Arrays.stream(ValidatorType.values())
				.filter(type -> type.getAnnotation() == annotation)
				.findAny()
				.orElse(null);
	}
}
