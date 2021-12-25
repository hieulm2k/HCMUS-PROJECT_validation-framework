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
 * This class used to define all test cases for min length validator
 *
 * @author Chi Cam Hao
 * @version 1.0.0
 * @since 1.0.0
 */
class MinLengthValidatorTest {
	Validation validation = Validation.getInstance();
	User user = new User();
	boolean isValid = true;
	String actualReason;

	@DisplayName("Test MinLengthValidator#validate valid user's address")
	@Test
	void testValidateValidAddress() {
		user.setName("Test");
		user.setPhoneNumber("0123456789");
		user.setEmail("test@gmail.com");
		user.setAge("21");
		user.setPassword("Test@123");
		user.setAddress("Ho Chi Minh city");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.ADDRESS.getProperty())) {
				isValid = false;
				break;
			}
		}

		Assertions.assertTrue(isValid);
	}

	@DisplayName("Test MinLengthValidator#validate invalid user's address")
	@Test
	void testValidateInvalidAddress() {
		user.setName("Test");
		user.setPhoneNumber("0123456789");
		user.setEmail("test@gmail.com");
		user.setAge("21");
		user.setPassword("Test@123");
		user.setAddress("city");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.ADDRESS.getProperty())) {
				isValid = false;
				actualReason = result.getReason();
				break;
			}
		}

		String expectReason = "Field's length must be greater than or equal to min length";
		Assertions.assertFalse(isValid);
		Assertions.assertEquals(expectReason, actualReason);
	}
}
