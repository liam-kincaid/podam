package uk.co.jemos.podam.test.unit.features.basicTypes;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.annotations.Title;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.test.dto.ClassGenericConstructorPojo;
import uk.co.jemos.podam.test.dto.ClassGenericPojo;
import uk.co.jemos.podam.test.dto.ClassPojo;
import uk.co.jemos.podam.test.unit.AbstractPodamSteps;

/**
 * Test @uk.co.jemos.podam.test.dto.JAXBElementPojo@ construction
 *
 * @author daivanov
 *
 */
@ExtendWith(SerenityJUnit5Extension.class)
public class ClassUnitTest extends AbstractPodamSteps {

	@Test
	@Title("Podam should handle the manufacturing of basic types")
	public void podamShouldHandleTheManufacturingOfBasicTypes() throws Exception {

		PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
		ClassPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass(ClassPojo.class, podamFactory);
		podamValidationSteps.thePojoMustBeOfTheType(pojo, ClassPojo.class);
		podamValidationSteps.thePojoMustBeOfTheType(pojo.getClazz(), Class.class);
		podamValidationSteps.theTwoObjectsShouldBeEqual(String.class, pojo.getClazz());
	}

	@Test
	@Title("Podam should handle the manufacturing of generic POJOs")
	public void podamShouldHandleTheManufacturingOfGenericPojos() throws Exception {

		PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
		ClassGenericPojo<?> pojo  = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
				ClassGenericPojo.class, podamFactory, String.class);
		podamValidationSteps.thePojoMustBeOfTheType(pojo, ClassGenericPojo.class);
		podamValidationSteps.thePojoMustBeOfTheType(pojo.getClazz(), Class.class);
		podamValidationSteps.theTwoObjectsShouldBeEqual(String.class, pojo.getClazz());
	}

	@Test
	@Title("Podam should handle the manufacturing of POJOs with generic types in constructor")
	public void podamShouldHandleTheManufacturingOfPojosWithGenericTypesInTheConstructor() throws Exception {

		PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();

		ClassGenericConstructorPojo<?> pojo = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
				ClassGenericConstructorPojo.class, podamFactory, String.class);
		podamValidationSteps.thePojoMustBeOfTheType(pojo, ClassGenericConstructorPojo.class);
		podamValidationSteps.thePojoMustBeOfTheType(pojo.getClazz(), Class.class);
		podamValidationSteps.theTwoObjectsShouldBeEqual(String.class, pojo.getClazz());
	}


}
