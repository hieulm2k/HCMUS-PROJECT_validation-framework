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
 * This class used to define all test cases for is email validator
 *
 * @author Tran Thanh Hien
 * @version 1.0.0
 * @since 1.0.0
 */
class IsEmailValidatorTest {
	Validation validation = Validation.getInstance();
	User user = new User();
	boolean isValid = true;
	String actualReason;

	@DisplayName("Test IsEmailValidator#validate valid user's email")
	@Test
	void testValidateValidEmail() {
		user.setName("Test");
		user.setPhoneNumber("0123456789");
		user.setEmail("test@gmail.com");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.EMAIL.getProperty())) {
				isValid = false;
				break;
			}
		}

		Assertions.assertTrue(isValid);
	}

	@DisplayName("Test IsEmailValidator#validate invalid user's email")
	@Test
	void testValidateInvalidEmail() {
		user.setName("Test");
		user.setPhoneNumber("0123456789");
		user.setEmail("test@gmail");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.EMAIL.getProperty())) {
				isValid = false;
				actualReason = result.getReason();
				break;
			}
		}

		String expectReason = "Field has wrong email format";
		Assertions.assertFalse(isValid);
		Assertions.assertEquals(expectReason, actualReason);
	}
}
