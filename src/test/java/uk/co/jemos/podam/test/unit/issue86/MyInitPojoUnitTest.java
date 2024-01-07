package uk.co.jemos.podam.test.unit.issue86;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uk.co.jemos.podam.api.DefaultClassInfoStrategy;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Created by tedonema on 14/04/2015.
 */
public class MyInitPojoUnitTest {

    private DefaultClassInfoStrategy classInfoStrategy = DefaultClassInfoStrategy.getInstance();


    private final PodamFactory podam = new PodamFactoryImpl();

    @BeforeEach
    public void init() throws Exception {
        classInfoStrategy.addExtraMethod(MyInitPojo.class, "init", String.class, String.class);
    }

    @Test
    public void testMyInitPojo() throws Exception {

        MyInitPojo pojo = podam.manufacturePojo(MyInitPojo.class);
        assertNotNull(pojo);
        assertNotSame(pojo.getString1(), pojo.getBackupString1());
        assertNotSame(pojo.getString2(), pojo.getBackupString2());
    }
}
