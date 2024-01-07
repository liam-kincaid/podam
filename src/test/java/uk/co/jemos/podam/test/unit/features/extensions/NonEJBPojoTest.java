package uk.co.jemos.podam.test.unit.features.extensions;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.annotations.Title;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.test.dto.NonEJBPojo;
import uk.co.jemos.podam.test.unit.AbstractPodamSteps;

/**
 * Test @uk.co.jemos.podam.test.dto.NonEJBPojo@ construction
 *
 * @author daivanov
 *
 */
@ExtendWith(SerenityJUnit5Extension.class)
public class NonEJBPojoTest extends AbstractPodamSteps {

	@Test
	@Title("Podam should handle attributes in accordance with custom Class Info Strategies")
	public void podamShouldHandleAttributesInAccordanceWithCustomClassInfoStrategies() throws Exception {

		NonEJBClassInfoStrategy classInfoStrategy = podamFactorySteps.givenANonEJBClassInfoStrategy();

		PodamFactory podamFactory = podamFactorySteps.givenAPodamFactoryWithCustomClassInfoStrategy(classInfoStrategy);
		podamValidationSteps.theTwoObjectsShouldBeEqual(podamFactory.getClassStrategy(), classInfoStrategy);

		NonEJBPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass(NonEJBPojo.class, podamFactory);
		podamValidationSteps.thePojoMustBeOfTheType(pojo, NonEJBPojo.class);
		podamValidationSteps.theStringFieldCannotBeNullOrEmpty(pojo.getMyString());
		podamValidationSteps.thePojoMustBeOfTheType(pojo.getMyLong(), Long.class);
	}
}
