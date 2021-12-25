package validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This class used to define annotation constraint if the value's length is less than or equal to the max
 *
 * @author Vo Van Ba Dat
 * @version 1.0.0
 * @since 1.0.0
 */
@Target( { ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxLength {
	int maxLength() default 0;

	String message() default "Field's length must be less than or equal to max length";
}
