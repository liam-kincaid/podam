package uk.co.jemos.podam.test.unit.steps;

import net.serenitybdd.annotations.Step;
import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.test.dto.OneDimensionalTestPojo;
import uk.co.jemos.podam.test.utils.TypesUtils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.junit.jupiter.api.Assertions.*;

public class OneDimentionalPojoValidationSteps {

    @Step("Then OneDimensionalTestPojo should be valid")
    public void validateDimensionalTestPojo(OneDimensionalTestPojo pojo, DataProviderStrategy strategy) {

        assertTrue(pojo.getBooleanObjectField(), "The boolean object field should have a value of TRUE");
        assertTrue(pojo.isBooleanField(), "The boolean field should have a value of TRUE");

        byte byteField = pojo.getByteField();
        assertNotEquals((byte) 0, byteField, "The byte field should not be zero");

        Byte byteObjectField = pojo.getByteObjectField();
        assertNotEquals((byte) 0, byteObjectField, "The Byte object field should not be zero");

        short shortField = pojo.getShortField();
        assertNotEquals((short) 0, shortField, "The short field should not be zero");

        Short shortObjectField = pojo.getShortObjectField();
        assertNotEquals((short) 0, shortObjectField, "The Short Object field should not be zero");

        char charField = pojo.getCharField();
        assertNotEquals((char) 0, charField, "The char field should not be zero");
        Character characterObjectField = pojo.getCharObjectField();
        assertNotEquals((char) 0, characterObjectField, "The Character object field should not be zero");

        int intField = pojo.getIntField();
        assertNotEquals(0, intField, "The int field cannot be zero");
        Integer integerField = pojo.getIntObjectField();
        assertNotEquals(0, integerField, "The Integer object field cannot be zero");

        long longField = pojo.getLongField();
        assertNotEquals(0L, longField, "The long field cannot be zero");
        Long longObjectField = pojo.getLongObjectField();
        assertNotEquals(0L, longField, "The Long object field cannot be zero");

        float floatField = pojo.getFloatField();
        assertNotEquals(0.0F, floatField, "The float field cannot be zero");
        Float floatObjectField = pojo.getFloatObjectField();
        assertNotEquals(0.0F, floatObjectField, "The Float object field cannot be zero");

        double doubleField = pojo.getDoubleField();
        assertNotEquals(0.0D, doubleField, "The double field cannot be zero");
        Double doubleObjectField = pojo.getDoubleObjectField();
        assertNotEquals(0.0D, doubleObjectField, "The Double object field cannot be zero");

        String stringField = pojo.getStringField();
        assertFalse(isBlank(stringField), "The String field cannot be empty");

        Object objectField = pojo.getObjectField();
        assertNotNull(objectField, "The Object field cannot be null");

        Calendar calendarField = pojo.getCalendarField();
        TypesUtils.checkCalendarIsValid(calendarField);

        Date dateField = pojo.getDateField();
        assertNotNull(dateField, "The date field is not valid");

        Random[] randomArray = pojo.getRandomArray();
        assertNotNull(randomArray, "The array of Random objects cannot be null!");
        assertEquals(strategy.getNumberOfCollectionElements(Random.class), randomArray.length, "The array of Random length should be one!");
        Random random = randomArray[0];
        assertNotNull(random, "The Random array element at [0] should not be null");

        int[] intArray = pojo.getIntArray();
        assertNotNull(intArray, "The array of ints cannot be null!");
        assertEquals(strategy.getNumberOfCollectionElements(Integer.class), intArray.length, "The array of ints length should be the same as defined in the strategy!");
        assertNotEquals(0, intArray[0], "The first element in the array of ints must be different from zero!");

        boolean[] booleanArray = pojo.getBooleanArray();
        assertNotNull(booleanArray, "The array of booleans cannot be null!");
        assertEquals(strategy.getNumberOfCollectionElements(Boolean.class), booleanArray.length, "The array of boolean length should be the same as the one set in the strategy!");

        BigDecimal bigDecimalField = pojo.getBigDecimalField();
        assertNotNull(bigDecimalField, "The BigDecimal field cannot be null!");

    }
}