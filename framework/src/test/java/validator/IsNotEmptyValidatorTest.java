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
 * This class used to define all test cases for is not empty validator
 *
 * @author Le Minh Hieu
 * @version 1.0.0
 * @since 1.0.0
 */
class IsNotEmptyValidatorTest {
	Validation validation = Validation.getInstance();
	User user = new User();
	boolean isValid = true;
	String actualReason;

	@DisplayName("Test IsNotEmptyValidator#validate valid user's name")
	@Test
	void testValidateValidName() {
		user.setName("Test");
		user.setPhoneNumber("0123456789");
		user.setEmail("test@gmail.com");
		user.setAge("21");
		user.setPassword("Test@123");
		user.setAddress("Ho Chi Minh city");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.NAME.getProperty())) {
				isValid = false;
				break;
			}
		}

		Assertions.assertTrue(isValid);
	}

	@DisplayName("Test IsNotEmptyValidator#validate invalid user's name")
	@Test
	void testValidateInvalidName() {
		user.setName("            ");
		user.setPhoneNumber("0123456789");
		user.setEmail("test@gmail.com");
		user.setAge("21");
		user.setPassword("Test@123");
		user.setAddress("Ho Chi Minh city");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.NAME.getProperty())) {
				isValid = false;
				actualReason = result.getReason();
				break;
			}
		}

		String expectReason = "Field must be not empty";
		Assertions.assertFalse(isValid);
		Assertions.assertEquals(expectReason, actualReason);
	}
}
