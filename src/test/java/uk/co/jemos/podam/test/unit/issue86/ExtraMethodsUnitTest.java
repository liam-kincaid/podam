package uk.co.jemos.podam.test.unit.issue86;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.jemos.podam.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by tedonema on 12/04/2015.
 */
public class ExtraMethodsUnitTest {


    private DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();

    private AbstractClassInfoStrategy classInfoStrategy = DefaultClassInfoStrategy.getInstance();

    private PodamFactory podam = new PodamFactoryImpl(dataProviderStrategy);

    @BeforeEach
    public void setup() throws Exception {

        classInfoStrategy.addExtraMethod(ExtraMethodsPojo.class, "setMyString", String.class);
        classInfoStrategy.addExtraMethod(ExtraMethodsPojo.class, "setMyLong", Long.class);
    }

    @Test
    public void testExtraMethods() throws Exception {

        ExtraMethodsPojo pojo = podam.manufacturePojo(ExtraMethodsPojo.class);
        assertNotNull(pojo, "The pojo cannot be null");
        assertNotNull(pojo.getMyLong(), "The long value cannot be zero");
        assertNotNull(pojo.getMyString(), "The string value cannot be null");
        assertFalse(pojo.getMyString().isEmpty(), "The string value cannot be empty");
    }
}
