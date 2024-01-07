/**
 * 
 */
package uk.co.jemos.podam.test.integration;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.test.dto.SimplePojoToTestSetters;
import uk.co.jemos.podam.test.unit.pdm3.Pdm3PojoUnitTest.TrackingExternalFactory;

/**
 * @author mtedone
 * 
 */
public class PodamFactoryInjectionIntegrationTest {

	// ------------------->> Constants

	// ------------------->> Instance / Static variables

	private static final TrackingExternalFactory trackingFactory = new TrackingExternalFactory();
	
	/** The Podam Factory */
	private static final PodamFactory factory = new PodamFactoryImpl(trackingFactory);

	// ------------------->> Constructors

	// ------------------->> Public methods

	@BeforeEach
	public void init() {
		assertNotNull(factory, "The PODAM factory cannot be null!");
		assertNotNull(factory.getStrategy(), "The factory strategy cannot be null!");
	}

	@Test
	public void testSimplePojo() {

		SimplePojoToTestSetters pojo = factory
				.manufacturePojo(SimplePojoToTestSetters.class);
		assertNotNull(pojo, "The pojo cannot be null!");

		int intField = pojo.getIntField();
		assertNotEquals(0, intField, "The int field cannot be zero!");

		String stringField = pojo.getStringField();
		assertNotNull(stringField, "The string field cannot be null!");
	}

	// ------------------->> Getters / Setters

	// ------------------->> Private methods

	// ------------------->> equals() / hashcode() / toString()

	// ------------------->> Inner classes

}
