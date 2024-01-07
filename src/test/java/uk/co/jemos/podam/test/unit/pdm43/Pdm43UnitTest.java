/**
 * 
 */
package uk.co.jemos.podam.test.unit.pdm43;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.test.dto.pdm43.ConcreteBusinessObject;

/**
 * Unit tests for <a href="http://www.jemos.eu/jira/browse/PDM-43">PDM-43</a>.
 * 
 * @author mtedone
 * 
 */
public class Pdm43UnitTest {

	@Test
	public void validateDtoInstantiation() {

		PodamFactory podamFactory = new PodamFactoryImpl();
		ConcreteBusinessObject pojo = podamFactory
				.manufacturePojo(ConcreteBusinessObject.class);
		assertNotNull(pojo, "The created POJO cannot be null!");

	}

}
