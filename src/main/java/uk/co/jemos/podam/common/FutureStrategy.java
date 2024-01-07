/**
 * 
 */
package uk.co.jemos.podam.common;

import java.lang.annotation.Annotation;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import uk.co.jemos.podam.exceptions.PodamMockeryException;

/**
 * This strategy fills {@link jakarta.validation.constraints.Future} attributes
 * and parameters annotated with Java bean validation annotations
 *
 * @author liam
 * @since 8.0.1.RELEASE
 */
public class FutureStrategy implements AttributeStrategy<Object>, CommonTypeOrStrategy {

    /**
     * Constructor for the strategy
     */
    public FutureStrategy() {
    	super();
    }

    /**
     * {@inheritDoc}
     */
    public Object getValue(Class<?> attrType, List<Annotation> annotations) throws PodamMockeryException {

    	AtomicReference<Long> seconds = new AtomicReference<>();
    	AtomicReference<Long> nanos = new AtomicReference<>();
        
        getSecondsNanos(annotations, seconds, nanos);

		if (Instant.class.isAssignableFrom(attrType)) {
			
	        return Instant.ofEpochSecond(seconds.get(), nanos.get());	        
		}
		
        Instant instant = Instant.ofEpochSecond(seconds.get(), nanos.get());

		if (LocalDateTime.class.isAssignableFrom(attrType)) {

	        return LocalDateTime.ofInstant(instant, getZoneId());
		}
		
		if (LocalDate.class.isAssignableFrom(attrType)) {

	        return LocalDateTime.ofInstant(instant, getZoneId()).toLocalDate();
		}
		
		if (LocalTime.class.isAssignableFrom(attrType)) {

	        return LocalDateTime.ofInstant(instant, getZoneId()).toLocalTime();
		}
		
		if (OffsetDateTime.class.isAssignableFrom(attrType)) {

	        return OffsetDateTime.ofInstant(instant, getZoneId());
		}
		
		if (OffsetTime.class.isAssignableFrom(attrType)) {

	        return OffsetTime.ofInstant(instant, getZoneId());
		}

		if (ZonedDateTime.class.isAssignableFrom(attrType)) {

			return ZonedDateTime.ofInstant(instant, getZoneId());
		}

		AtomicReference<Integer> years = new AtomicReference<>();
		AtomicReference<Integer> months = new AtomicReference<>();
		AtomicReference<Integer> days = new AtomicReference<>();

		getYearsMonthsDays(annotations, years, months, days);

		if (Year.class.isAssignableFrom(attrType)) {

			return Year.of(years.get());
		}

		if (Year.class.isAssignableFrom(attrType)) {

			return Year.of(years.get());
		}

		if (YearMonth.class.isAssignableFrom(attrType)) {

			return YearMonth.of(years.get(), months.get());
		}

		AtomicReference<Long> timestamps = new AtomicReference<>();

		getTimestamps(annotations, timestamps);

		if (Date.class.isAssignableFrom(attrType)) {

			return new Date(timestamps.get());
		}

		if (Calendar.class.isAssignableFrom(attrType)) {

			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(timestamps.get());
			return calendar;
		}

		return null;
    }
}
