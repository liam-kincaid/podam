package uk.co.jemos.podam.test.unit.features.annotations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import net.serenitybdd.annotations.Title;
import org.junit.jupiter.api.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.exceptions.PodamMockeryException;
import uk.co.jemos.podam.test.dto.annotations.*;

/**
 * Created by tedonema on 12/06/2015.
 */
public class AnnotationsExceptionsTest {

    private PodamFactory podamFactory;

    //TODO Can't serenify until issue #79 has been resolved

    @BeforeEach
    public void init() {
        podamFactory = new PodamFactoryImpl();
    }

    @Test
    public void podamShouldThrowExceptionWhenPodamIntegerValueContainsInvalidCharacters() throws Exception {
        Assertions.assertThrows(PodamMockeryException.class, () -> {
            podamFactory.manufacturePojo(IntegerValueWithErrorPojo.class);
        });
    }

    @Test
    @Title("Podam should throw an exception if the @PodamLongValue annotation contains invalid characters")
    public void podamShouldThrowExceptionWhenPodamLongValueContainsInvalidCharacters() throws Exception {
        Assertions.assertThrows(PodamMockeryException.class, () -> {
            podamFactory.manufacturePojo(LongValueWithErrorPojo.class);
        });
    }


    @Test
    @Title("Podam should throw an exception if the @PodamByteValue annotation contains invalid characters")
    public void podamShouldThrowExceptionWhenPodamByteValueContainsInvalidCharacters() throws Exception {
        Assertions.assertThrows(PodamMockeryException.class, () -> {
            podamFactory.manufacturePojo(ByteValueWithErrorPojo.class);
        });
    }

    @Test
    @Title("Podam should throw an exception if the @PodamShortValue annotation contains invalid characters")
    public void podamShouldThrowExceptionWhenPodamShortValueContainsInvalidCharacters() throws Exception {
        Assertions.assertThrows(PodamMockeryException.class, () -> {
            podamFactory.manufacturePojo(ShortValueWithErrorPojo.class);
        });
    }

    @Test
    @Title("Podam should throw an exception if the @PodamFloatValue annotation contains invalid characters")
    public void podamShouldThrowExceptionWhenPodamFloatValueContainsInvalidCharacters() throws Exception {
        Assertions.assertThrows(PodamMockeryException.class, () -> {
            podamFactory.manufacturePojo(FloatValueWithErrorPojo.class);
        });
    }



    @Test
    @Title("Podam should throw an exception if the @PodamDoubleValue annotation contains invalid characters")
    public void podamShouldThrowExceptionWhenPodamDoubleValueContainsInvalidCharacters() throws Exception {
        Assertions.assertThrows(PodamMockeryException.class, () -> {
            podamFactory.manufacturePojo(DoubleValueWithErrorPojo.class);
        });
    }

    @Test
    @Title("Podam should throw an exception if the @PodamStrategyValue annotation contains the wrong strateg type")
    public void podamShouldThrowExceptionWhenPodamStrategyValueContainsInvalidStrategy() throws Exception {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            podamFactory.manufacturePojo(StringWithWrongStrategyTypePojo.class);
        });
    }
}
