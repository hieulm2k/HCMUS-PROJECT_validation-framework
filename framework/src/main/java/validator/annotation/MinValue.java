package validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This class used to define annotation constraint a value is greater than or equal to the min.
 *
 * @author Vo Van Ba Dat
 * @version 1.0.0
 * @since 1.0.0
 */
@Target( { ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MinValue {
	double min() default 0;

	String message() default "Field must be greater than or equal to min value";
}
