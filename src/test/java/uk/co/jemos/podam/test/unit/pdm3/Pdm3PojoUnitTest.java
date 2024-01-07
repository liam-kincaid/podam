/**
 * 
 */
package uk.co.jemos.podam.test.unit.pdm3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import uk.co.jemos.podam.api.AbstractExternalFactory;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.test.dto.*;
import uk.co.jemos.podam.test.dto.pdm3.Pdm3Pojo;
import uk.co.jemos.podam.test.dto.pdm3.Pdm3PojoConstructor;
import uk.co.jemos.podam.test.dto.pdm3.Pdm3PojoGenericsConstructor;
import uk.co.jemos.podam.test.dto.pdm3.WildcardPojo;

import java.lang.reflect.Type;
import java.util.*;

import jakarta.xml.bind.JAXBElement;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Marco Tedone
 * 
 */
public class Pdm3PojoUnitTest {

	public static class TrackingExternalFactory extends AbstractExternalFactory {

		List<Class<?>> failures = new ArrayList<Class<?>>();

		@Override
		public <T> T manufacturePojo(Class<T> pojoClass, Type... genericTypeArgs) {
			failures.add(pojoClass);
			return null;
		}

		@Override
		public <T> T populatePojo(T pojo, Type... genericTypeArgs) {
			return pojo;
		}
	}

	private static final TrackingExternalFactory trackingFactory
			= new TrackingExternalFactory();

	private static final PodamFactory factory = new PodamFactoryImpl(trackingFactory);

	@BeforeEach
	public void start() {
		trackingFactory.failures.clear();
	}

	@AfterEach
	public void end() {
		assertEquals(0, trackingFactory.failures.size(), trackingFactory.failures.toString());
	}

	@Disabled("JAXBElement<?> could not been initialized !!!")
	@Test
	public void testPdm3WildcardPojo() {

		WildcardPojo pojo = factory.manufacturePojo(WildcardPojo.class);
		assertNotNull(pojo);
		assertCollection(pojo.getSomething(), JAXBElement.class);
		assertCollection(pojo.getDescendants(), JAXBElement.class);
		assertCollection(pojo.getAncestors(), JAXBElement.class);
	}

	@Disabled("List<?> could not been initialized !!!")
	@Test
	public void testPdm3Pojo() {

		Pdm3Pojo pojo = factory.manufacturePojo(Pdm3Pojo.class);
		assertNotNull(pojo);
		assertCollection(pojo.getSomething(), Object.class);
		assertCollection(pojo.getDescendants(), RuntimeException.class);
		assertCollection(pojo.getAncestors(), NullPointerException.class);
	}

	@Disabled("String does not extends RuntimeException !!!")
	@Test
	public void testPdm3PojoConstructor() {

		Pdm3PojoConstructor<?> pojo = factory.manufacturePojo(Pdm3PojoConstructor.class, String.class);
		assertNotNull(pojo);
		assertNotNull(pojo.getName());
	}

	@Disabled("String does not extends RuntimeException !!!")
	@Test
	public void testPdm3ListOfPojos() {

		List<?> pojos =
			factory.manufacturePojo(ArrayList.class, Pdm3PojoConstructor.class, String.class);
		assertCollection(pojos, Pdm3PojoConstructor.class);
	}

	@Disabled("String does not extends RuntimeException !!!")
	@Test
	public void testPdm3MapOfPojos() {

		Map<?, ?> pojos =
			factory.manufacturePojo(HashMap.class, Integer.class, Pdm3PojoConstructor.class, String.class);
		assertMap(pojos, Integer.class, Pdm3PojoConstructor.class);
	}

	@Test
	public void testPdm3ExtendingListOfPojos() {

		Collection<?> pojos = factory.manufacturePojo(CollectionExtendingGenericsPojo.class);
		assertCollection(pojos, String.class);
	}

	@Test
	public void testPdm3ExtendingRawListOfPojos() {

		Collection<?> pojos = factory.manufacturePojo(CollectionExtendingNoGenericsPojo.class);
		assertCollection(pojos, Object.class);
	}

	@Test
	public void testPdm3IndirectImplementingListOfPojos() {

		Collection<?> pojos = factory.manufacturePojo(CollectionIndirectRawImplPojo.class);
		assertCollection(pojos, Object.class);
	}

	@Test
	public void testPdm3ImplementingListOfPojos() {

		Collection<?> pojos = factory.manufacturePojo(CollectionImplementingGenericsInterface.class);
		assertCollection(pojos, String.class);
	}

	@Test
	public void testPdm3ExtendingImplementingListOfPojos() {

		Collection<?> pojos = factory.manufacturePojo(CollectionExtendingImplementingPojo.class);
		assertCollection(pojos, String.class);
	}

	@Test
	public void testPdm3ExtendingMapOfPojos() {

		Map<?,?> pojos = factory.manufacturePojo(MapExtendingGenericsPojo.class);
		assertMap(pojos, Integer.class, String.class);
	}

	@Test
	public void testPdm3ExtendingNonRawMapOfPojos() {

		Map<?,?> pojos = factory.manufacturePojo(MapExtendingNoGenericsPojo.class);
		assertMap(pojos, Object.class, Object.class);
	}

	@Test
	public void testPdm3IndirectImplementingMapOfPojos() {

		Map<?,?> pojos = factory.manufacturePojo(MapIndirectRawImplPojo.class);
		assertMap(pojos, Object.class, Object.class);
	}

	@Test
	public void testPdm3ImplementingMapOfPojos() {

		Map<?,?> pojos = factory.manufacturePojo(MapImplementingGenericInterface.class);
		assertMap(pojos, Integer.class, String.class);
	}

	@Test
	public void testPdm3ExtendingImplementingMapOfPojos() {

		Map<?,?> pojos = factory.manufacturePojo(MapExtendingImplementingPojo.class);
		assertMap(pojos, Integer.class, String.class);
	}

	@Disabled("List<?> could not been initialized !!!")
	@Test
	public void testPdm3PojoGenericsConstructor() {

		Pdm3PojoGenericsConstructor pojo = factory.manufacturePojo(Pdm3PojoGenericsConstructor.class);
		assertNotNull(pojo);
		assertCollection(pojo.getSomething(), Object.class);
		assertCollection(pojo.getDescendants(), RuntimeException.class);
		assertCollection(pojo.getAncestors(), NullPointerException.class);
	}

	@Disabled("List<?> could not been initialized !!!")
	@Test
	public void testPdm3ListOfGenericPojos() {

		List<?> pojos =
			factory.manufacturePojo(ArrayList.class, Pdm3PojoGenericsConstructor.class);
		assertCollection(pojos, Pdm3PojoGenericsConstructor.class);
	}

	@Disabled("List<?> could not been initialized !!!")
	@Test
	public void testPdm3MapOfGenericPojos() {

		Map<?, ?> pojos =
			factory.manufacturePojo(HashMap.class, String.class, Pdm3PojoGenericsConstructor.class);
		assertMap(pojos, String.class, Pdm3PojoGenericsConstructor.class);
	}

	private void assertCollection(Collection<?> collection, Class<?> elementType) {

		assertNotNull(collection, "The collection should not be null");
		assertFalse(collection.isEmpty(), "The collection should not be empty");
		for (Object obj : collection) {
			assertNotNull(obj, "Collection element should not be null");
			assertInstanceOf(elementType, obj, "Wrong element's type");
			if (obj instanceof Pdm3PojoConstructor<?> pojo) {
				assertNotNull(pojo.getName(), "Element's field should not be empty");
				assertInstanceOf(RuntimeException.class, pojo.getName(), "Element's type is String");
			}
		}
	}

	private void assertMap(Map<?,?> map, Class<?> keyType, Class<?> valueType) {

		assertNotNull(map, "The map should not be null");
		assertFalse(map.keySet().isEmpty(), "The map should not be empty");
		for (Object key : map.keySet()) {
			assertNotNull(key, "Key should not be empty");
			assertInstanceOf(keyType, key, "Wrong element's type");
			Object value = map.get(key);
			assertNotNull(value, "Value should not be empty");
			assertInstanceOf(valueType, value, "Wrong element's type");
			if (value instanceof Pdm3PojoConstructor<?> pojo) {
                assertNotNull(pojo.getName(), "Element's field should not be empty");
				assertInstanceOf(RuntimeException.class, pojo.getName(), "Element's type is String");
			}
		}
	}
}
