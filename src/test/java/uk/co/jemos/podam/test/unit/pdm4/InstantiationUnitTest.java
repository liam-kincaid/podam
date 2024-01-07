/**
 * Test multiple constructors with setters
 */
package uk.co.jemos.podam.test.unit.pdm4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterEach;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.test.dto.pdm4.Pdm4PojoWithSetters;
import uk.co.jemos.podam.test.dto.pdm4.PojoWithFactoryMethods;
import uk.co.jemos.podam.test.dto.pdm4.PojoWithMultipleNonPublicConstructors;

/**
 * @author divanov
 *
 */
public class InstantiationUnitTest {

	private static final PodamFactory factory = new PodamFactoryImpl();

	@AfterEach
	public void cleanup() {
		Pdm4PojoWithSetters.invocationOrder.clear();
		PojoWithMultipleNonPublicConstructors.invocationOrder.clear();
		PojoWithFactoryMethods.invocationOrder.clear();
	}
	
	@Test
	public void testPdm4PojoWithSetters() {

		Pdm4PojoWithSetters pojo = factory.manufacturePojo(Pdm4PojoWithSetters.class);
		assertNull(pojo, "POJO should not be created");
		assertEquals(5, Pdm4PojoWithSetters.invocationOrder.size(), "Invocation order has changed");
		assertEquals("PodamConstructor", Pdm4PojoWithSetters.invocationOrder.get(0), "Invocation order has changed");
		assertEquals("no-op", Pdm4PojoWithSetters.invocationOrder.get(1), "Invocation order has changed");
		assertEquals("InputStream", Pdm4PojoWithSetters.invocationOrder.get(2), "Invocation order has changed");
		assertEquals("int,int", Pdm4PojoWithSetters.invocationOrder.get(3), "Invocation order has changed");
		assertEquals("abstract,int", Pdm4PojoWithSetters.invocationOrder.get(4), "Invocation order has changed");
	}

	@Test
	public void testPojoWithMultipleNonPublicConstructors() {

		PojoWithMultipleNonPublicConstructors pojo = factory.manufacturePojo(PojoWithMultipleNonPublicConstructors.class);
		assertNull(pojo, "POJO should not be created");
		assertEquals(5, PojoWithMultipleNonPublicConstructors.invocationOrder.size(), "Invocation order has changed");
		assertEquals("PodamConstructor", PojoWithMultipleNonPublicConstructors.invocationOrder.get(0), "Invocation order has changed");
		assertEquals("no-op", PojoWithMultipleNonPublicConstructors.invocationOrder.get(1), "Invocation order has changed");
		assertEquals("InputStream", PojoWithMultipleNonPublicConstructors.invocationOrder.get(2), "Invocation order has changed");
		assertEquals("int,int", PojoWithMultipleNonPublicConstructors.invocationOrder.get(3), "Invocation order has changed");
		assertEquals("abstract,int", PojoWithMultipleNonPublicConstructors.invocationOrder.get(4), "Invocation order has changed");
	}

	@Test
	public void testPojoWithFactoryMethods() {

		PojoWithFactoryMethods pojo = factory.manufacturePojo(PojoWithFactoryMethods.class);
		assertNull(pojo, "POJO should not be created");
		assertEquals(7, PojoWithFactoryMethods.invocationOrder.size(), "Invocation order has changed");
		assertEquals("PodamConstructor(str)", PojoWithFactoryMethods.invocationOrder.get(0), "Invocation order has changed");
		assertEquals("PodamConstructor(str,bool)", PojoWithFactoryMethods.invocationOrder.get(1), "Invocation order has changed");
		assertEquals("PodamConstructor(str,abstract)", PojoWithFactoryMethods.invocationOrder.get(2), "Invocation order has changed");
		assertEquals("no-op", PojoWithFactoryMethods.invocationOrder.get(3), "Invocation order has changed");
		assertEquals("InputStream", PojoWithFactoryMethods.invocationOrder.get(4), "Invocation order has changed");
		assertEquals("int,int", PojoWithFactoryMethods.invocationOrder.get(5), "Invocation order has changed");
		assertEquals("abstract,int", PojoWithFactoryMethods.invocationOrder.get(6), "Invocation order has changed");
	}

	@Test
	public void testPdm4PojoWithFullData() {

		Pdm4PojoWithSetters pojo = factory.manufacturePojoWithFullData(
				Pdm4PojoWithSetters.class);
		assertNull(pojo, "POJO should not be created");
		assertEquals(5, Pdm4PojoWithSetters.invocationOrder.size(), "Invocation order has changed");
		assertEquals("PodamConstructor", Pdm4PojoWithSetters.invocationOrder.get(0), "Invocation order has changed");
		assertEquals("int,int", Pdm4PojoWithSetters.invocationOrder.get(1), "Invocation order has changed");
		assertEquals("abstract,int", Pdm4PojoWithSetters.invocationOrder.get(2), "Invocation order has changed");
		assertEquals("InputStream", Pdm4PojoWithSetters.invocationOrder.get(3), "Invocation order has changed");
		assertEquals("no-op", Pdm4PojoWithSetters.invocationOrder.get(4), "Invocation order has changed");
	}

	@Test
	public void testPojoWithMultipleNonPublicConstructorsWithFullData() {

		PojoWithMultipleNonPublicConstructors pojo = factory.manufacturePojoWithFullData(
				PojoWithMultipleNonPublicConstructors.class);
		assertNull(pojo, "POJO should not be created");
		assertEquals(5, PojoWithMultipleNonPublicConstructors.invocationOrder.size(), "Invocation order has changed");
		assertEquals("PodamConstructor", PojoWithMultipleNonPublicConstructors.invocationOrder.get(0), "Invocation order has changed");
		assertEquals("int,int", PojoWithMultipleNonPublicConstructors.invocationOrder.get(1), "Invocation order has changed");
		assertEquals("abstract,int", PojoWithMultipleNonPublicConstructors.invocationOrder.get(2), "Invocation order has changed");
		assertEquals("InputStream", PojoWithMultipleNonPublicConstructors.invocationOrder.get(3), "Invocation order has changed");
		assertEquals("no-op", PojoWithMultipleNonPublicConstructors.invocationOrder.get(4), "Invocation order has changed");
	}

	@Test
	public void testPojoWithFactoryMethodsWithFullData() {

		PojoWithFactoryMethods pojo = factory.manufacturePojoWithFullData(PojoWithFactoryMethods.class);
		assertNull(pojo, "POJO should not be created");
		assertEquals(7, PojoWithFactoryMethods.invocationOrder.size(), "Invocation order has changed");
		assertEquals("PodamConstructor(str,bool)", PojoWithFactoryMethods.invocationOrder.get(0), "Invocation order has changed");
		assertEquals("PodamConstructor(str,abstract)", PojoWithFactoryMethods.invocationOrder.get(1), "Invocation order has changed");
		assertEquals("PodamConstructor(str)", PojoWithFactoryMethods.invocationOrder.get(2), "Invocation order has changed");
		assertEquals("int,int", PojoWithFactoryMethods.invocationOrder.get(3), "Invocation order has changed");
		assertEquals("abstract,int", PojoWithFactoryMethods.invocationOrder.get(4), "Invocation order has changed");
		assertEquals("InputStream", PojoWithFactoryMethods.invocationOrder.get(5), "Invocation order has changed");
		assertEquals("no-op", PojoWithFactoryMethods.invocationOrder.get(6), "Invocation order has changed");
	}
}
