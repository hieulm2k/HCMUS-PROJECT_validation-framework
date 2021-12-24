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
 * This class used to define all test cases for is mobile phone validator
 *
 * @author Chi Cam Hao
 * @version 1.0.0
 * @since 1.0.0
 */
class IsMobilePhoneValidatorTest {
	Validation validation = Validation.getInstance();
	User user = new User();
	boolean isValid = true;
	String actualReason;

	@DisplayName("Test IsMobilePhoneValidator#validate valid user's phone number")
	@Test
	void testValidateValidPhoneNumber() {
		user.setName("Test");
		user.setPhoneNumber("0123456789");
		user.setEmail("test@gmail.com");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.PHONE_NUMBER.getProperty())) {
				isValid = false;
				break;
			}
		}

		Assertions.assertTrue(isValid);
	}

	@DisplayName("Test IsMobilePhoneValidator#validate invalid user's phone number")
	@Test
	void testValidateInvalidLengthOfPhoneNumber() {
		user.setName("Test");
		user.setPhoneNumber("012345");
		user.setEmail("test@gmail.com");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.PHONE_NUMBER.getProperty())) {
				isValid = false;
				actualReason = result.getReason();
				break;
			}
		}

		String expectReason = "Field has wrong mobile phone format";
		Assertions.assertFalse(isValid);
		Assertions.assertEquals(expectReason, actualReason);
	}

	@DisplayName("Test IsMobilePhoneValidator#validate invalid user's phone number")
	@Test
	void testValidateInvalidCharOfPhoneNumber() {
		user.setName("Test");
		user.setPhoneNumber("01a2b3c4d5");
		user.setEmail("test@gmail.com");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.PHONE_NUMBER.getProperty())) {
				isValid = false;
				actualReason = result.getReason();
				break;
			}
		}

		String expectReason = "Field has wrong mobile phone format";
		Assertions.assertFalse(isValid);
		Assertions.assertEquals(expectReason, actualReason);
	}
}
