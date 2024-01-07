package uk.co.jemos.podam.test.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.Date;

public abstract class TypesUtils {

    /**
     * It checks that the Calendar instance is valid
     * <p>
     * If the calendar returns a valid date then it's a valid instance
     * </p>
     *
     * @param calendarField The calendar instance to check
     */
    public static void checkCalendarIsValid(Calendar calendarField) {
        assertNotNull(calendarField, "The Calendar field cannot be null");
        Date calendarDate = calendarField.getTime();
        assertNotNull(calendarDate, "It appears the Calendar field is not valid");
    }
}