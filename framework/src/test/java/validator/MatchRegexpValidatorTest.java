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
 * This class used to define all test cases for match regexp validator
 *
 * @author Le Minh Hieu
 * @version 1.0.0
 * @since 1.0.0
 */
class MatchRegexpValidatorTest {
	Validation validation = Validation.getInstance();
	User user = new User();
	boolean isValid = true;
	String actualReason;

	@DisplayName("Test MatchRegexpValidator#validate valid user's password")
	@Test
	void testValidateValidPassword() {
		user.setName("Test");
		user.setPhoneNumber("0123456789");
		user.setEmail("test@gmail.com");
		user.setAge("21");
		user.setPassword("Test@123");
		user.setAddress("Ho Chi Minh city");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.PASSWORD.getProperty())) {
				isValid = false;
				break;
			}
		}

		Assertions.assertTrue(isValid);
	}

	@DisplayName("Test MatchRegexpValidator#validate invalid user's age")
	@Test
	void testValidateInvalidAge() {
		user.setName("Test");
		user.setPhoneNumber("0123456789");
		user.setEmail("test@gmail.com");
		user.setAge("21");
		user.setPassword("test");
		user.setAddress("Ho Chi Minh city");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.PASSWORD.getProperty())) {
				isValid = false;
				actualReason = result.getReason();
				break;
			}
		}

		String expectReason = "Password is too weak";
		Assertions.assertFalse(isValid);
		Assertions.assertEquals(expectReason, actualReason);
	}
}
