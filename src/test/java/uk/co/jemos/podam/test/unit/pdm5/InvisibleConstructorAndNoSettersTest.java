/**
 * Test multiple constructors with setters
 */
package uk.co.jemos.podam.test.unit.pdm5;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.test.dto.pdm5.InvisibleConstructorAndNoSettersPojo;

/**
 * @author divanov
 *
 */
public class InvisibleConstructorAndNoSettersTest {

	@Test
	public void testInvisibleConstructorAndNoSetters() {

		PodamFactory factory = new PodamFactoryImpl();
		InvisibleConstructorAndNoSettersPojo pojo = factory.manufacturePojo(
				InvisibleConstructorAndNoSettersPojo.class);
		assertNotNull(pojo);
	}
}
