package validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This class used to define annotation constraint a value is less than or equal to the max.
 *
 * @author Tran Thanh Hien
 * @version 1.0.0
 * @since 1.0.0
 */
@Target( { ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxValue {
	double max() default 0;

	String message() default "Field must be less than or equal to max value";
}
