package validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This class used to define annotation constraint a value is a number
 *
 * @author Le Minh Hieu
 * @version 1.0.0
 * @since 1.0.0
 */
@Target( { ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsNumber {
	String message() default "Field must be a number";
}
