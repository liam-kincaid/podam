package uk.co.jemos.podam.test.unit.steps;

import net.serenitybdd.annotations.Step;
import uk.co.jemos.podam.test.dto.RecursivePojo;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by tedonema on 30/05/2015.
 */
public class RecursivePojoValidationSteps {

    @Step("Then all the POJOs in the recursive hierarchy should be valid")
    public void allPojosInTheRecursiveStrategyShouldBeValid(RecursivePojo pojo) {

        assertNotEquals(0, pojo.getIntField(), "The integer value in the pojo should not be zero!");

        RecursivePojo parentPojo = pojo.getParent();
        assertNotNull(parentPojo, "The parent pojo cannot be null!");
        assertNotEquals(0, parentPojo.getIntField(), "The integer value in the parent pojo should not be zero!");
        assertNotNull(parentPojo.getParent(), "The parent attribute of the parent pojo cannot be null!");

    }
}
