package uk.co.jemos.podam.test.unit.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import net.serenitybdd.annotations.Step;

import java.util.Set;

/**
 * Created by tedonema on 21/06/2015.
 */
public class ValidatorSteps {

    @Step("Then the POJO should not have any Validator violations for {1}")
    public <T> void thePojoShouldNotViolateAnyValidations(Validator validator, T pojo) throws Exception {

        Set<ConstraintViolation<T>> violations = validator.validate(pojo);
        assertTrue(violations.isEmpty(), "There should be no violations");
    }
}
