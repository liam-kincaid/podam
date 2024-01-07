package uk.co.jemos.podam.test.unit.steps;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;
import static org.junit.jupiter.api.Assertions.*;

import net.serenitybdd.annotations.Step;

import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.test.utils.TypesUtils;

import java.lang.reflect.Array;
import java.time.*;
import java.util.*;

/**
 * Created by tedonema on 27/05/2015.
 */
public class PodamValidationSteps {

    @Step("Then the object {0} should not be null")
    public void theObjectShouldNotBeNull(Object pojo) {
        assertNotNull(pojo);
    }

    @Step("Then the Pojo should contain some data")
    public void thePojoShouldContainSomeData(Object pojo) {
        assertTrue(pojo.getClass().getDeclaredFields().length > 0);
    }

    @Step("Then the Pojo should be null")
    public void thePojoShouldBeNull(Object pojo) {
        assertNull(pojo);
    }

    @Step("Then the string {0} should match the pattern {1}")
    public void theStringMatchesAPattern(String string, String pattern) {
        assertTrue(string.matches(pattern), string + " doesn't match " + pattern);
    }

    @Step("Then the int field should not be zero")
    public void theIntFieldShouldNotBeZero(int intField) {
        assertNotEquals(0, intField, "The integer field should not be zero");
    }

    @Step("The long value cannot be zero")
    public void theLongValueShouldNotBeZero(long value) {
        assertTrue(value > 0, "The long value cannot be zero");
    }

    @Step("Then any field annotated with @PodamExclude should be null")
    public void anyFieldWithPodamExcludeAnnotationShouldBeNull(Object someObject) {
        assertNull(someObject, "The field should be null");
    }

    @Step("Then the integer field should be greater or equal to zero")
    public void theIntFieldShouldBeGreaterOrEqualToZero(int intField) {
        assertTrue(intField >= 0, "The integer field should be greater or equal to zero");
    }

    @Step("Then the integer field {0} should have a value not greater than {1}")
    public void theIntFieldShouldHaveValueNotGreaterThan(int intField, int maxValue) {
        assertTrue(intField <= maxValue, "The int field should have a value <= " + maxValue);
    }

    @Step("Then the integer field {2} should have a value between {0} and {1}")
    public void theIntFieldShouldHaveValueBetween(int minValue, int maxValue, int intField) {
        assertTrue(intField >= minValue && intField <= maxValue, "The integer field value " + intField + " should be between " + minValue + " and " + maxValue);
    }

    @Step("Then the integer field {0} should have the precise value of {1}")
    public void theIntFieldShouldHaveThePreciseValueOf(int intFieldWithPreciseValue, int preciseValue) {
        assertEquals(intFieldWithPreciseValue, preciseValue);
    }

    @Step("Then the long field {0} should be greater or equal to zero")
    public void theLongFieldShouldBeGreaterOrEqualToZero(long longFieldValue) {
        assertTrue(longFieldValue >= 0, "The long field should be >= 0");
    }

    @Step("Then the long field {0} should be less than {1}")
    public void theLongFieldShouldHaveValueNotGreaterThan(long longValue, int maxValue) {
        assertTrue(longValue <= maxValue, "The long value " + longValue + " should be <= " + maxValue);
    }

    @Step("Then the long field {2} should have a value comprised between {0} and {1}")
    public void theLongFieldShouldHaveValueBetween(int minValue, int maxValue, long longValue) {
        assertTrue(longValue >= minValue && longValue <= maxValue, "The long value should have a value between " + minValue + " and " + maxValue);
    }

    @Step("Then the long value should be precisely {1}")
    public void theLongFieldShouldHaveThePreciseValueOf(long longValueWithPreciseValue, long preciseValue) {
        assertEquals(longValueWithPreciseValue, preciseValue);
    }

    @Step("Then the int value {0} should be less or equal to {1}")
    public void theIntFieldShouldHaveValueLessThen(int intField, int maxValue) {
        assertTrue(intField <= maxValue, "The int value " + intField + " should be <= " + maxValue);
    }

    @Step("Then the calendar value should be valid")
    public void theCalendarFieldShouldBeValid(Calendar calendarField) {
        TypesUtils.checkCalendarIsValid(calendarField);
    }

    @Step("Then the String field {0} cannot be null or empty")
    public void theStringFieldCannotBeNullOrEmpty(String strField) {
        assertNotNull(strField, "The string object value should not be null");
        assertTrue(isNoneBlank(strField));
    }

    @Step("Then the pojo {0} must be of the type {1}")
    public void thePojoMustBeOfTheType(Object pojo, Class<?> type) {
        assertInstanceOf(type, pojo, "The pojo must be of the type");
    }

    @Step("Then the byte value {0} should be greater or equal than {1}")
    public void theByteValueShouldBeGreaterOrEqualThan(byte byteValue, int minValue) {
        assertTrue(byteValue >= minValue, "The byte value should be >= " + minValue);
    }

    @Step("Then the byte value {0} should be lower or equal to {1}")
    public void theByteValueShouldBeLowerOrEqualThan(byte byteValue, int maxValue) {
        assertTrue(byteValue <= maxValue, "The byte value " + byteValue + " should be <= " + maxValue);
    }

    @Step("Then the byte value {0} should be between {1} and {2}")
    public void theByteValueShouldBeBetween(byte byteValue, int minValue, int maxValue) {
        assertTrue(byteValue >= minValue && byteValue <= maxValue, "The byte value should be between " + minValue + " and " + maxValue);
    }

    @Step("The byte value {0} should be precisely {1}")
    public void theByteValueShouldHavePreciselyValueOf(byte byteValue, byte preciseValue) {
        assertEquals(byteValue, preciseValue);
    }

    @Step("Then the value {0} should be greater or equal than {1}")
    public void theShortValueShouldBeGreaterOrEqualThan(short shortValue, int minValue) {
        assertTrue(shortValue >= minValue, "The value " + shortValue + " should be >= " + minValue);
    }

    @Step("Then the short value {0} should be lower or equal than {1}")
    public void theShortValueShouldBeLowerOrEqualThan(short shortValue, int maxValue) {
        assertTrue(shortValue <= maxValue, "The short value " + shortValue + "should be <= " + maxValue);
    }

    @Step("Then the short value {0} should be between {1} and {2}")
    public void theShortValueShouldBeBetween(short shortValue, int minValue, int maxValue) {
        assertTrue(shortValue >= minValue && shortValue <= maxValue, "The short value " + shortValue + " should be between " + minValue + " and " + maxValue);
    }

    @Step("Then the short value {0} should be precisely {1}")
    public void theShortPreciseValueShouldBe(short shortFieldWithPreciseValue, short preciseValue) {
        assertEquals(shortFieldWithPreciseValue, preciseValue);
    }

    @Step("Then the char value should be greater or equal than {1}")
    public void theCharValueShouldBeGreaterOrEqualThan(char charValue, char minValue) {
        assertTrue(charValue >= minValue, "The char value " + charValue + " should be >= " + minValue);
    }

    @Step("Then the char value should be lower or equal than {1}")
    public void theCharValueShouldBeLowerOrEqualThan(char charValue, int maxValue) {
        assertTrue(charValue <= maxValue, "The char value " + charValue + " should be <= " + maxValue);
    }

    @Step("Then the char value should be between {1} and {2}")
    public void theCharValueShouldBeBetween(char charValue, int minValue, int maxValue) {
        assertTrue(charValue >= minValue && charValue <= maxValue, "The char value should be between " + minValue + " and " + maxValue);
    }

    @Step("Then the char value {0} should be exactly {1}")
    public void theCharValueShouldBeExactly(char charValue, char preciseValue) {
        assertEquals(charValue, preciseValue);
    }

    @Step("Then the boolean value {0} should be true")
    public void theBooleanValueIsTrue(boolean boolValue) {
        assertTrue(boolValue, "The boolean value should be true");
    }

    @Step("The boolean value {0} should be false")
    public void theBooleanValueShouldBeFalse(boolean boolValue) {
        assertFalse(boolValue, "The boolean value should be false");
    }

    @Step("Then the Float value {0} should be greater or equal than {1}")
    public void theFloatValueShouldBeGreaterOrEqualThan(float floatValue, float minValue) {
        assertTrue(floatValue <= minValue, "The Float value should be <= " + minValue);
    }

    @Step("Then the float value {0} should be lower or equal than {1}")
    public void theFloatValueShouldBeLowerOrEqualThan(float floatValue, float maxValue) {
        assertTrue(floatValue <= maxValue, "The float value should be >= " + maxValue);
    }

    @Step("Then the float value {0} should be between {1} and {2}")
    public void theFloatValueShouldBeBetween(float floatValue, float minValue, float maxValue) {
        assertTrue(floatValue >= minValue && floatValue <= maxValue, "The float value should be between " + minValue + " and " + maxValue);
    }

    @Step("Then the float value {0} should be precisely {1}")
    public void theFloatValueShouldBePrecisely(float floatValue, float preciseValue) {
        assertEquals(floatValue, preciseValue);
    }

    @Step("Then the double value (0} should be greater or equal than {1}")
    public void theDoubleValueShouldBeGreaterOrEqualThan(double doubleValue, double minValue) {
        assertTrue(doubleValue >= minValue, "The double value should be >= " + minValue);
    }

    @Step("Then the double value {0} should be lower or equal than {1}")
    public void theDoubleValueShouldBeLowerOrEqualThan(double doubleValue, double maxValue) {
        assertTrue(doubleValue <= maxValue, "The double value should be <= " + maxValue);
    }

    @Step("Then the double value {0} should be between {1} and {2}")
    public void theDoubleValueShouldBeBetween(double doubleValue, double minValue, double maxValue) {
        assertTrue(doubleValue >= minValue && doubleValue <= maxValue, "The double value should be between " + minValue + " and " + maxValue);
    }

    @Step("Then the double value {0} should be exactly {1}")
    public void theDoubleValueShouldBeExactly(double doubleValue, double preciseValue) {
        assertEquals(doubleValue, preciseValue);
    }

    @Step("Then the string value {0} should have the length of {1}")
    public void theStringValueShouldHaveTheExactLengthOf(String stringValue, int stringLength) {
        assertEquals(stringValue.length(), stringLength, "The length of the string should be " + stringLength);
    }

    @Step("Then string [{0}] should be exactly like string [{1}]")
    public void theStringValueShouldBeExactly(String stringValue, String annotationPreciseValue) {
        assertEquals(stringValue, annotationPreciseValue);
    }

    @Step("Then the array should have exactly {1} elements")
    public void theArrayShouldHaveExactlyTheExpectedNumberOfElements(Object array, int nbrElements) {
        int length = Array.getLength(array);
        assertEquals(length, nbrElements, "The collection should have exactly " + nbrElements + " elements");
    }

    @Step("Then the map should not be null or empty and each element should have key of type {1} and value of type {2} and have exactly {3} elements")
    public void theMapShouldNotBeNullOrEmptyAndShouldHaveExactlyTheExpectedNumberOfElements(
            Map<?, ?> map, Class<?> keyType, Class<?> valueType, int nbrElements) {
        theMapShouldNotBeNullOrEmptyAndContainElementsOfType(map, keyType, valueType);
        assertEquals(map.size(), nbrElements, "The map should have exactly " + nbrElements + " elements");
    }

    @Step("Then the collection should not be null or empty")
    public void theCollectionShouldNotBeNullOrEmpty(Collection<?> collection) {
        assertNotNull(collection, "The collection should not be null");
        assertFalse(collection.isEmpty(), "The collection should not be empty");
    }

    @Step("Then the collection should have exactly {1} elements")
    public void theCollectionShouldHaveExactlyTheExpectedNumberOfElements(Collection<?> collection, int nbrElements) {
        assertEquals(collection.size(), nbrElements, "The collection should have exactly " + nbrElements + " elements");
    }

    @Step("Then the collection should have should have elements of type {1} and exactly {2} elements")
    public void theCollectionShouldNotBeNullOrEmptyAndShouldHaveExactlyTheExpectedNumberOfElements(
            Collection<?> collection, Class<?> elementType, int nbrElements) {
        theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType(collection, elementType);
        theCollectionShouldHaveExactlyTheExpectedNumberOfElements(collection, nbrElements);
    }

    @Step("Then the calendar object should have exactly the value of calendar object {1}")
    public void theTwoCalendarObjectsShouldHaveTheSameTime(Calendar expectedValue, Calendar actualValue) {
        assertEquals(actualValue.getTime().getTime(), expectedValue.getTime().getTime(), "Calendar values must be equal");
    }

    @Step("Then the given array should not be null or empty and contain elements of type {1}")
    public void theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainElementsOfTheRightType(Object array, Class<?> elementType) {
        assertNotNull(array, "Array should not be null");
        int length = Array.getLength(array);
        assertTrue(length > 0, "Array should not be empty");
        for (int i = 0; i < length; i++) {
            Object element = Array.get(array, i);
            assertInstanceOf(elementType, element, "Wrong element type");
        }
    }

    @Step("Then the object should be null")
    public void theValueShouldBeNull(Object value) {
        assertNull(value, "The value is not null");
    }

    @Step("Then the two objects {0} and {1} should be equal")
    public void theTwoObjectsShouldBeEqual(Object expectedObject, Object actualObject) {
        assertEquals(expectedObject, actualObject, "The two objects are not equal");
    }

    @Step("Then the object should be null")
    public void theObjectShouldBeNull(Object pojo) {
        assertNull(pojo, "The object should be null");
    }

    @Step("Then the collection should not be null or empty and each element should be of type {1}")
    public void theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType(Collection<?> collection, Class<?> elementType) {
        theCollectionShouldNotBeNullOrEmpty(collection);
        for (Object element : collection) {
            assertInstanceOf(elementType, element, "Wrong element type");
        }
    }

    @Step("Then the Map should not be null or empty and each element should have key of type {1} and value of type {2}")
    public void theMapShouldNotBeNullOrEmptyAndContainElementsOfType(Map<?,?> map, Class<?> keyType, Class<?> valueType) {
        theMapShouldNotBeNullOrEmpty(map);
        for (Map.Entry<?, ?> element : map.entrySet()) {
            assertInstanceOf(keyType, element.getKey(), "Wrong key type");
            assertInstanceOf(valueType, element.getValue(), "Wrong value type");
        }
    }

    @Step("Then the map should be empty")
    public void theMapShouldBeEmpty(Map<?, ?> map) {
    	assertNotNull(map, "The Map must not be null!");
        assertTrue(map.keySet().isEmpty(), "The Map should be empty");
    }

    @Step("Then the collection should be empty")
    public void theCollectionShouldBeEmpty(Collection<?> collection) {
    	assertNotNull(collection, "The Collection must not be null!");
        assertTrue(collection.isEmpty(), "The Collection should be empty");
    }

    @Step("Then the {0} and {1} should be strictly equal (e.g. according to == operator)")
    public void theTwoObjectsShouldBeStrictlyEqual(Object pojo1, Object pojo2) {
        assertEquals(pojo1, pojo2, "The two objects are not strictly equal");
    }

    @Step("Then the {0} and {1} should be different")
    public void theTwoObjectsShouldBeDifferent(Object pojo1, Object pojo2) {
        assertNotEquals(pojo1, pojo2, "The two objects should be different");
    }

    @Step("Then the collection should contain at least one element of type {1}")
    public void theCollectionShouldContainAtLeastOneElementOfType(Collection<?> accessed, Class<?> type) {
        assertTrue(accessed.contains(type), "The collection doesn't contain an element of type " + type);
    }

    @Step("Then the array of the given type should not be null or empty and contain exactly {1} elements of type {2}")
    public void theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainExactlyTheGivenNumberOfElements(
            Object array, int size, Class<?> elementType) {
        theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainElementsOfTheRightType(array, elementType);
        theArrayShouldHaveExactlyTheExpectedNumberOfElements(array, size);
    }

    @Step("Then the map should not be null or empty")
    private void theMapShouldNotBeNullOrEmpty(Map<?, ?> map) {
        assertNotNull(map, "The map should not be null");
        assertFalse(map.keySet().isEmpty(), "The map should not be empty");
    }

    @Step("Then Data Provider Strategy should have memoization {1}")
    public void theMemoizationShouldBeEnabled(DataProviderStrategy strategy, boolean isMemoizationEnabled) {
        assertEquals(isMemoizationEnabled, strategy.isMemoizationEnabled(), "Payload must be valid");
    }

    @Step("Then {@link java.time.Instant} should be in the futur")
    public void theInstantShouldInTheFutur(Instant pojo) {
        assertNotNull(pojo, "The {@link java.time.Instant} should not be null");
        assertTrue(pojo.isAfter(Instant.now()), "The {@link java.time.Instant} should be in the futur");
    }

    @Step("Then {@link java.time.Instant} should be in the futur or present")
    public void theInstantShouldInTheFuturOrPresent(Instant pojo) {
        assertNotNull(pojo, "The {@link java.time.Instant} should not be null");
        assertTrue(pojo.isAfter(Instant.now()), "The {@link java.time.Instant} should be in the futur or present");
    }

    @Step("Then {@link java.time.Instant} should be in the past or present")
    public void theInstantShouldInThePastOrPresent(Instant pojo) {
        assertNotNull(pojo, "The {@link java.time.Instant} should not be null");
        assertTrue(pojo.isBefore(Instant.now()), "The {@link java.time.Instant} should be in the past or present");
    }

    @Step("Then {@link java.time.Instant} should be in the past")
    public void theInstantShouldInThePast(Instant pojo) {
        assertNotNull(pojo, "The {@link java.time.Instant} should not be null");
        assertTrue(pojo.isBefore(Instant.now()), "The {@link java.time.Instant} should be in the past");
    }

    @Step("Then {@link java.time.LocalDateTime} should be in the futur")
    public void theLocalDateTimeShouldInTheFutur(LocalDateTime pojo) {
        assertNotNull(pojo, "The {@link java.time.LocalDateTime} should not be null");
        assertTrue(pojo.isAfter(LocalDateTime.now()), "The {@link java.time.LocalDateTime} should be in the futur");
    }

    @Step("Then {@link java.time.LocalDateTime} should be in the futur or present")
    public void theLocalDateTimeShouldInTheFuturOrPresent(LocalDateTime pojo) {
        assertNotNull(pojo, "The {@link java.time.LocalDateTime} should not be null");
        assertTrue(pojo.isAfter(LocalDateTime.now()), "The {@link java.time.LocalDateTime} should be in the futur or present");
    }

    @Step("Then {@link java.time.LocalDateTime} should be in the past or present")
    public void theLocalDateTimeShouldInThePastOrPresent(LocalDateTime pojo) {
        assertNotNull(pojo, "The {@link java.time.LocalDateTime} should not be null");
        assertTrue(pojo.isBefore(LocalDateTime.now()), "The {@link java.time.LocalDateTime} should be in the past or present");
    }

    @Step("Then {@link java.time.LocalDateTime} should be in the past")
    public void theLocalDateTimeShouldInThePast(LocalDateTime pojo) {
        assertNotNull(pojo, "The {@link java.time.LocalDateTime} should not be null");
        assertTrue(pojo.isBefore(LocalDateTime.now()), "The {@link java.time.LocalDateTime} should be in the past");
    }

    @Step("Then {@link java.time.LocalDate} should be in the futur")
    public void theLocalDateShouldInTheFutur(LocalDate pojo) {
        assertNotNull(pojo, "The {@link java.time.LocalDate} should not be null");
        assertTrue(pojo.isAfter(LocalDate.now()), "The {@link java.time.LocalDate} should be in the futur");
    }

    @Step("Then {@link java.time.LocalDate} should be in the futur or present")
    public void theLocalDateShouldInTheFuturOrPresent(LocalDate pojo) {
        assertNotNull(pojo, "The {@link java.time.LocalDate} should not be null");
        assertTrue(pojo.isAfter(LocalDate.now()), "The {@link java.time.LocalDate} should be in the futur or present");
    }

    @Step("Then {@link java.time.LocalDate} should be in the past or present")
    public void theLocalDateShouldInThePastOrPresent(LocalDate pojo) {
        assertNotNull(pojo, "The {@link java.time.LocalDate} should not be null");
        assertTrue(pojo.isBefore(LocalDate.now()), "The {@link java.time.LocalDate} should be in the past or present");
    }

    @Step("Then {@link java.time.LocalDate} should be in the past")
    public void theLocalDateShouldInThePast(LocalDate pojo) {
        assertNotNull(pojo, "The {@link java.time.LocalDate} should not be null");
        assertTrue(pojo.isBefore(LocalDate.now()), "The {@link java.time.LocalDate} should be in the past");
    }

    @Step("Then {@link java.time.LocalTime} should be in the futur or present")
    public void theLocalTimeShouldInTheFuturOrPresent(LocalTime pojo) {
        assertNotNull(pojo, "The {@link java.time.LocalTime} should not be null");
        assertTrue(pojo.isAfter(LocalTime.now()), "The {@link java.time.LocalTime} should be in the futur or present");
    }

    @Step("Then {@link java.time.LocalTime} should be in the past or present")
    public void theLocalTimeShouldInThePastOrPresent(LocalTime pojo) {
        assertNotNull(pojo, "The {@link java.time.LocalTime} should not be null");
        assertTrue(pojo.isBefore(LocalTime.now()), "The {@link java.time.LocalTime} should be in the past or present");
    }

    @Step("Then {@link java.time.LocalTime} should be in the past")
    public void theLocalTimeShouldInThePast(LocalTime pojo) {
        assertNotNull(pojo, "The {@link java.time.LocalTime} should not be null");
        assertTrue(pojo.isBefore(LocalTime.now()), "The {@link java.time.LocalTime} should be in the past");
    }

    @Step("Then {@link java.time.OffsetDateTime} should be in the futur")
    public void theOffsetDateTimeShouldInTheFutur(OffsetDateTime pojo) {
        assertNotNull(pojo, "The {@link java.time.OffsetDateTime} should not be null");
        assertTrue(pojo.isAfter(OffsetDateTime.now()), "The {@link java.time.OffsetDateTime} should be in the futur");
    }

    @Step("Then {@link java.time.OffsetDateTime} should be in the futur or present")
    public void theOffsetDateTimeShouldInTheFuturOrPresent(OffsetDateTime pojo) {
        assertNotNull(pojo, "The {@link java.time.OffsetDateTime} should not be null");
        assertTrue(pojo.isAfter(OffsetDateTime.now()), "The {@link java.time.OffsetDateTime} should be in the futur or present");
    }

    @Step("Then {@link java.time.OffsetDateTime} should be in the past or present")
    public void theOffsetDateTimeShouldInThePastOrPresent(OffsetDateTime pojo) {
        assertNotNull(pojo, "The {@link java.time.OffsetDateTime} should not be null");
        assertTrue(pojo.isBefore(OffsetDateTime.now()), "The {@link java.time.OffsetDateTime} should be in the past or present");
    }

    @Step("Then {@link java.time.OffsetDateTime} should be in the past")
    public void theOffsetDateTimeShouldInThePast(OffsetDateTime pojo) {
        assertNotNull(pojo, "The {@link java.time.OffsetDateTime} should not be null");
        assertTrue(pojo.isBefore(OffsetDateTime.now()), "The {@link java.time.OffsetDateTime} should be in the past");
    }

    @Step("Then {@link java.time.YearMonth} should be in the futur")
    public void theYearMonthShouldInTheFutur(YearMonth pojo) {
        assertNotNull(pojo, "The {@link java.time.YearMonth} should not be null");
        assertTrue(pojo.isAfter(YearMonth.now()), "The {@link java.time.YearMonth} should be in the futur");
    }

    @Step("Then {@link java.time.YearMonth} should be in the futur or present")
    public void theYearMonthShouldInTheFuturOrPresent(YearMonth pojo) {
        assertNotNull(pojo, "The {@link java.time.YearMonth} should not be null");
        assertTrue(pojo.isAfter(YearMonth.now()), "The {@link java.time.YearMonth} should be in the futur or present");
    }

    @Step("Then {@link java.time.YearMonth} should be in the past or present")
    public void theYearMonthShouldInThePastOrPresent(YearMonth pojo) {
        assertNotNull(pojo, "The {@link java.time.YearMonth} should not be null");
        assertTrue(pojo.isBefore(YearMonth.now()), "The {@link java.time.YearMonth} should be in the past or present");
    }

    @Step("Then {@link java.time.YearMonth} should be in the past")
    public void theYearMonthShouldInThePast(YearMonth pojo) {
        assertNotNull(pojo, "The {@link java.time.YearMonth} should not be null");
        assertTrue(pojo.isBefore(YearMonth.now()), "The {@link java.time.YearMonth} should be in the past");
    }

    @Step("Then {@link java.time.Year} should be in the futur")
    public void theYearShouldInTheFutur(Year pojo) {
        assertNotNull(pojo, "The {@link java.time.Year} should not be null");
        assertTrue(pojo.isAfter(Year.now()), "The {@link java.time.Year} should be in the futur");
    }

    @Step("Then {@link java.time.Year} should be in the futur or present")
    public void theYearShouldInTheFuturOrPresent(Year pojo) {
        assertNotNull(pojo, "The {@link java.time.Year} should not be null");
        assertTrue(pojo.isAfter(Year.now()), "The {@link java.time.Year} should be in the futur or present");
    }

    @Step("Then {@link java.time.Year} should be in the past or present")
    public void theYearShouldInThePastOrPresent(Year pojo) {
        assertNotNull(pojo, "The {@link java.time.Year} should not be null");
        assertTrue(pojo.isBefore(Year.now()), "The {@link java.time.Year} should be in the past or present");
    }

    @Step("Then {@link java.time.Year} should be in the past")
    public void theYearShouldInThePast(Year pojo) {
        assertNotNull(pojo, "The {@link java.time.Year} should not be null");
        assertTrue(pojo.isBefore(Year.now()), "The {@link java.time.Year} should be in the past");
    }

    @Step("Then {@link java.time.ZonedDateTime} should be in the futur")
    public void theZonedDateTimeShouldInTheFutur(ZonedDateTime pojo) {
        assertNotNull(pojo, "The {@link java.time.ZonedDateTime} should not be null");
        assertTrue(pojo.isAfter(ZonedDateTime.now()), "The {@link java.time.ZonedDateTime} should be in the futur");
    }

    @Step("Then {@link java.time.ZonedDateTime} should be in the futur or present")
    public void theZonedDateTimeShouldInTheFuturOrPresent(ZonedDateTime pojo) {
        assertNotNull(pojo, "The {@link java.time.ZonedDateTime} should not be null");
        assertTrue(pojo.isAfter(ZonedDateTime.now()), "The {@link java.time.ZonedDateTime} should be in the futur or present");
    }

    @Step("Then {@link java.time.ZonedDateTime} should be in the past or present")
    public void theZonedDateTimeShouldInThePastOrPresent(ZonedDateTime pojo) {
        assertNotNull(pojo, "The {@link java.time.ZonedDateTime} should not be null");
        assertTrue(pojo.isBefore(ZonedDateTime.now()), "The {@link java.time.ZonedDateTime} should be in the past or present");
    }

    @Step("Then {@link java.time.ZonedDateTime} should be in the past")
    public void theZonedDateTimeShouldInThePast(ZonedDateTime pojo) {
        assertNotNull(pojo, "The {@link java.time.ZonedDateTime} should not be null");
        assertTrue(pojo.isBefore(ZonedDateTime.now()), "The {@link java.time.ZonedDateTime} should be in the past");
    }
}
