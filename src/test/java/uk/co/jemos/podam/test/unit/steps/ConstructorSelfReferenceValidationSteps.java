package uk.co.jemos.podam.test.unit.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import net.serenitybdd.annotations.Step;
import uk.co.jemos.podam.test.dto.ConstructorWithSelfReferencesButNoDefaultConstructorPojo;
import uk.co.jemos.podam.test.dto.ConstructorWithSelfReferencesPojoAndDefaultConstructor;

/**
 * Created by tedonema on 31/05/2015.
 */
public class ConstructorSelfReferenceValidationSteps {

    @Step("Then the first self-reference for a POJO with default constructor should not be null")
    public void theFirstSelfReferenceForPojoWithDefaultConstructorShouldNotBeNull(ConstructorWithSelfReferencesPojoAndDefaultConstructor parentPojo) {
        assertNotNull(parentPojo.getParent(), "The first self-reference should not be null");
    }

    @Step("Then the second self-reference for a POJO with default constructor should not be null")
    public void theSecondSelfReferenceForPojoWithDefaultConstructorShouldNotBeNull(ConstructorWithSelfReferencesPojoAndDefaultConstructor parentPojo) {
        assertNotNull(parentPojo.getAnotherParent(), "The second self-reference should not be null");
    }

    @Step("Then the first self-reference for a POJO without default constructor should not be null")
    public void theFirstSelfReferenceForPojoWithoutDefaultConstructorShouldNotBeNull(ConstructorWithSelfReferencesButNoDefaultConstructorPojo parentPojo) {
        assertNotNull(parentPojo.getParent(), "The first self-reference should not be null");
    }

    @Step("Then the first self-reference for a POJO without default constructor should not be null")
    public void theSecondSelfReferenceForPojoWithoutDefaultConstructorShouldNotBeNull(ConstructorWithSelfReferencesButNoDefaultConstructorPojo parentPojo) {
        assertNotNull(parentPojo.getAnotherParent(), "The seciond self-reference should not be null");
    }
}
