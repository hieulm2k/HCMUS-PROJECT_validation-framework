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

	@DisplayName("Test IsNotEmptyValidation#validate valid user's name")
	@Test
	void testValidateValidName() {
		user.setName("Test");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.NAME.getProperty())) {
				isValid = false;
				break;
			}
		}

		Assertions.assertTrue(isValid);
	}

	@DisplayName("Test IsNotEmptyValidation#validate invalid user's name")
	@Test
	void testValidateInvalidName() {
		user.setName("            ");
		Set<ValidatorResult> resultSet = validation.validate(user);

		for (ValidatorResult result : resultSet) {
			if (Objects.equals(result.getProperty(), UserProperty.NAME.getProperty())) {
				isValid = false;
				break;
			}
		}

		Assertions.assertFalse(isValid);
	}
}
