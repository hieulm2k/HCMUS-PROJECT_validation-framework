package validator;

import java.util.Objects;
import java.util.Set;

import common.UserProperty;
import facade.Validation;
import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class used to define all test cases for is number validator
 *
 * @author Le Minh Hieu
 * @version 1.0.0
 * @since 1.0.0
 */
class IsNumberValidatorTest {
	Validation validation = Validation.getInstance();
	User user = new User();
	boolean isValid = true;
	String actualReason;

	@DisplayName("Test IsNumberValidator#validate valid user's age")
	@Test
	void testValidateValidAge() {
		user.setName("Test");
		user.setPhoneNumber("0123456789");
		user.setEmail("test@gmail.com");
		user.setAge("21");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.AGE.getProperty())) {
				isValid = false;
				break;
			}
		}

		Assertions.assertTrue(isValid);
	}

	@DisplayName("Test IsAgeValidator#validate invalid user's age")
	@Test
	void testValidateInvalidAge() {
		user.setName("Test");
		user.setPhoneNumber("0123456789");
		user.setEmail("test@gmail.com");
		user.setAge("age");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.AGE.getProperty())) {
				isValid = false;
				actualReason = result.getReason();
				break;
			}
		}

		String expectReason = "Field must be a number";
		Assertions.assertFalse(isValid);
		Assertions.assertEquals(expectReason, actualReason);
	}
}
