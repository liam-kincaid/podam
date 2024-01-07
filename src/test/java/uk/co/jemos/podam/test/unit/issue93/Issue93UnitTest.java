package uk.co.jemos.podam.test.unit.issue93;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Created by tedonema on 05/05/2015.
 */
public class Issue93UnitTest {

    @Test
    public void testLoop()  {
        A a =new PodamFactoryImpl().manufacturePojo(A.class);
        assertNotNull(a, "The Pojo for class A should not be null");
    }
}
