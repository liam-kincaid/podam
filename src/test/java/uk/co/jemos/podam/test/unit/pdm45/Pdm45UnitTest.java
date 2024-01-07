/**
 * 
 */
package uk.co.jemos.podam.test.unit.pdm45;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.api.RandomDataProviderStrategyImpl;
import uk.co.jemos.podam.test.dto.PodamParameterizedType;
import uk.co.jemos.podam.test.dto.pdm45.GenericArrayPojo;
import uk.co.jemos.podam.test.dto.pdm45.GenericAttributePojo;
import uk.co.jemos.podam.test.dto.pdm45.GenericListPojo;
import uk.co.jemos.podam.test.dto.pdm45.GenericMapPojo;
import uk.co.jemos.podam.test.dto.pdm45.GenericPojo;
import uk.co.jemos.podam.test.dto.pdm45.MultiDimensionalConstructorPojo;
import uk.co.jemos.podam.test.dto.pdm45.MultiDimensionalTestPojo;

import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.Map.Entry;

/**
 * Unit tests for <a href="http://www.jemos.eu/jira/browse/PDM-45">PDM-45</a>.
 * 
 * @author marciocarmona
 * 
 */
public class Pdm45UnitTest {

	/** The podam factory */
	private PodamFactory factory;

	@BeforeEach
	public void init() {

		factory = new PodamFactoryImpl(new RandomDataProviderStrategyImpl());

	}

	@Test
	public void testGenericListPojoManufacture() {
		@SuppressWarnings("unchecked")
		final GenericListPojo<Double, Boolean> pojo = factory.manufacturePojo(GenericListPojo.class, Double.class, Boolean.class);
		assertNotNull(pojo, "The GenericPojo object cannot be null!");

		List<GenericPojo<Double, Boolean>> pojos = pojo.getGenericPojos();
		for (GenericPojo<Double, Boolean> element : pojos) {
			validateGenericPojo(element, Double.class, Boolean.class);
		}
	}

	@Test
	public void testGenericMapPojoManufacture() {
		@SuppressWarnings("unchecked")
		final GenericMapPojo<Double, Boolean> pojo = factory.manufacturePojo(GenericMapPojo.class, Double.class, Boolean.class);
		assertNotNull(pojo, "The GenericPojo object cannot be null!");

		Map<String,GenericPojo<Double, Boolean>> pojos = pojo.getGenericPojos();
		for (GenericPojo<Double, Boolean> element : pojos.values()) {
			validateGenericPojo(element, Double.class, Boolean.class);
		}

		Map<String, List<?>> rawLists = pojo.getGenericRawLists();
		for (Entry<String, List<?>> entry : rawLists.entrySet()) {
			String key = entry.getKey();
			assertNotNull(key, "Map key cannot be null");
			List<?> list = entry.getValue();
			assertNotNull(list, "Map value cannot be null");
			for (Object item : list) {
				assertNotNull(item, "List element cannot be null");
			}
		}
	}

	@Test
	public void testGenericArrayPojoManufacture() {
		@SuppressWarnings("unchecked")
		final GenericArrayPojo<Double, Boolean> pojo = factory.manufacturePojo(GenericArrayPojo.class, Double.class, Boolean.class);
		assertNotNull(pojo, "The GenericPojo object cannot be null!");

		GenericPojo<Double, Boolean>[] pojos = pojo.getGenericPojos();
		for (GenericPojo<Double, Boolean> element : pojos) {
			validateGenericPojo(element, Double.class, Boolean.class);
		}
	}

	@Test
	public void testPojoWithGenericFields() {
		final GenericAttributePojo pojo = factory.manufacturePojo(GenericAttributePojo.class);
		assertNotNull(pojo, "The GenericPojo object cannot be null!");

		final GenericPojo<String, Long> genericPojo = pojo.getGenericPojo();
		validateGenericPojo(genericPojo, String.class, Long.class);
	}

	@Test
	public void testGenericPojoManufacture() {
		@SuppressWarnings("unchecked")
		final GenericPojo<Double, Boolean> pojo = factory.manufacturePojo(GenericPojo.class, Double.class, Boolean.class);
		validateGenericPojo(pojo, Double.class, Boolean.class);
	}

	private void validateGenericPojo(GenericPojo<?,?> pojo, Class<?> typeParam1, Class<?> typeParam2) {

		assertNotNull(pojo, "The GenericPojo object cannot be null!");
		
		assertNotNull(pojo.getFirstValue(), "The generated object cannot be null!");
		assertEquals(typeParam1, pojo.getFirstValue().getClass(), "The generated object must be a Double!");
		assertNotNull(pojo.getSecondValue(), "The generated object cannot be null!");
		assertEquals(typeParam2, pojo.getSecondValue().getClass(), "The generated object must be a Boolean!");
		assertNotNull(pojo.getFirstList(), "The generated list cannot be null!");
		assertEquals(typeParam1, pojo.getFirstList().get(0).getClass(), "The generated list type must be of Double!");
		assertNotNull(pojo.getSecondArray(), "The generated array cannot be null!");
		assertEquals(typeParam2, pojo.getSecondArray()[0].getClass(), "The generated array type must be of Boolean!");
		assertNotNull(pojo.getFirstSecondMap(), "The generated map cannot be null!");
		assertEquals(typeParam1, pojo.getFirstSecondMap().entrySet().iterator().next().getKey().getClass(), "The generated map key type must be of Double!");
		assertEquals(typeParam2, pojo.getFirstSecondMap().entrySet().iterator().next().getValue().getClass(), "The generated map value type must be of Boolean!");
	}

	@Test
	public void testMultiDimensionalTestPojo() {
		final MultiDimensionalTestPojo pojo = factory.manufacturePojo(MultiDimensionalTestPojo.class);
		
		checkMultiDimensionalPojo(pojo);
	}

	@Test
	public void testConstructorMultiDimensionalPojo() {
		final MultiDimensionalConstructorPojo pojo = factory.manufacturePojo(MultiDimensionalConstructorPojo.class);
		
		checkMultiDimensionalPojo(pojo);
	}

	@Test
	public void testParametrizedNestedGenericPojo() {
		ParameterizedType paremetrizedGenericPojo =
				new PodamParameterizedType(GenericPojo.class, String.class, Long.class);

		ParameterizedType paremetrizedMap =
				new PodamParameterizedType(Map.class, Integer.class, String.class);

		@SuppressWarnings("unchecked")
		GenericPojo<GenericPojo<String, Long>, Map<Integer, String>> pojo =
				factory.manufacturePojo(GenericPojo.class, paremetrizedGenericPojo, paremetrizedMap);
		assertInstanceOf(GenericPojo.class, pojo, "The pojo must be of the type");
		assertInstanceOf(GenericPojo.class, pojo.getFirstValue(), "Value must of the type");
		assertInstanceOf(String.class, pojo.getFirstValue().getFirstValue(), "Value must of the type");
		assertInstanceOf(Long.class, pojo.getFirstValue().getSecondValue(), "Value must of the type");
		assertInstanceOf(Map.class, pojo.getSecondValue(), "Value must of the type");
		assertInstanceOf(Integer.class, pojo.getSecondValue().keySet().iterator().next(), "Value must of the type");
		assertInstanceOf(String.class, pojo.getSecondValue().values().iterator().next(), "Value must of the type");
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testMultiDimensionalPojoManufacture() {
		ParameterizedType twoDimensionalStringListType =
				new PodamParameterizedType(List.class, 
						new PodamParameterizedType(List.class,
								String.class));
		ParameterizedType longDoubleMapType =
				new PodamParameterizedType(Map.class, Long.class, Double.class);
		
		final GenericPojo<List<List<String>>, Map<Long, Double>> pojo =
				factory.manufacturePojo(GenericPojo.class, twoDimensionalStringListType, longDoubleMapType);
		
		assertNotNull(pojo, "The GenericPojo object cannot be null!");
		
		assertNotNull(pojo.getFirstValue(), "The generated object cannot be null!");
		assertEquals(String.class, pojo.getFirstValue().get(0).get(0).getClass(), "The generated object must be a String!");
		assertNotNull(pojo.getSecondValue(), "The generated object cannot be null!");
		assertEquals(Long.class, pojo.getSecondValue().keySet().iterator().next().getClass(), "The generated object must be a Long!");
		assertEquals(Double.class, pojo.getSecondValue().values().iterator().next().getClass(), "The generated object must be a Double!");
		assertNotNull(pojo.getFirstList(), "The generated list cannot be null!");
		assertEquals(String.class, pojo.getFirstList().get(0).get(0).get(0).getClass(), "The generated list type must be of String!");
		assertNotNull(pojo.getSecondArray(), "The generated array cannot be null!");
		assertEquals(Long.class, pojo.getSecondArray()[0].keySet().iterator().next().getClass(), "The generated array type must be of Long!");
		assertEquals(Double.class, pojo.getSecondArray()[0].values().iterator().next().getClass(), "The generated array type must be of Double!");
		assertNotNull(pojo.getFirstSecondMap(), "The generated map cannot be null!");
		assertEquals(String.class, pojo.getFirstSecondMap().entrySet().iterator().next().getKey().get(0).get(0).getClass(), "The generated map key type must be of String!");
		assertEquals(Long.class, pojo.getFirstSecondMap().entrySet().iterator().next().getValue().keySet().iterator().next().getClass(), "The generated map value type must be of Long!");
		assertEquals(Double.class, pojo.getFirstSecondMap().entrySet().iterator().next().getValue().values().iterator().next().getClass(), "The generated map value type must be of Double!");
	}

	/**
	 * It validates a {@link MultiDimensionalTestPojo}.
	 * 
	 * @param pojo the pojo to validate
	 */
	private void checkMultiDimensionalPojo(final MultiDimensionalTestPojo pojo) {
		assertNotNull(pojo, "The GenericPojo object cannot be null!");
		
		checkMultiDimensionalCollection(pojo.getThreeDimensionalList(), String.class);
		checkMultiDimensionalCollection(pojo.getThreeDimensionalQueue(), Date.class);
		checkMultiDimensionalCollection(pojo.getThreeDimensionalSet(), Double.class);
		checkMultiDimensionalCollection(pojo.getThreeDimensionalCollection(), Long.class);
		
		assertEquals(2, pojo.getThreeDimensionalArray().length, "The generated Array must have size=2!");
		assertEquals(2, pojo.getThreeDimensionalArray()[0].length, "The generated Array must have size=2!");
		assertEquals(2, pojo.getThreeDimensionalArray()[0][0].length, "The generated Array must have size=2!");
		assertEquals(String.class, pojo.getThreeDimensionalArray()[0][0][0].getClass(), "The generated Array must be of String!");
		
		// Boolean key is always true, so just have one element
		assertEquals(1, pojo.getThreeDimensionalMap().size(), "The generated Map must have size=1!");
		Entry<Boolean, Map<Float, Map<Integer, Calendar>>> entry =
				pojo.getThreeDimensionalMap().entrySet().iterator().next();
		assertEquals(Boolean.class, entry.getKey().getClass(), "The generated Map entry key must be of Boolean!");
		assertEquals(2, entry.getValue().size(), "The generated Map must have size=2!");
		Entry<Float, Map<Integer, Calendar>> entry2 = entry.getValue().entrySet().iterator().next();
		assertEquals(Float.class, entry2.getKey().getClass(), "The generated Map entry key must be of Float!");
		assertEquals(2, entry2.getValue().size(), "The generated Map must have size=2!");
		Entry<Integer, Calendar> entry3 = entry2.getValue().entrySet().iterator().next();
		assertEquals(Integer.class, entry3.getKey().getClass(), "The generated Map entry key must be of Integer!");
		assertEquals(GregorianCalendar.class, entry3.getValue().getClass(), "The generated Map entry key must be of Calendar!");
	}

	/**
	 * It validates a {@link MultiDimensionalTestPojo} collection.
	 * 
	 * @param <T> the type of the class to validate
	 * @param collection the collection to validate
	 * @param type the type of the class to validate
     */
	@SuppressWarnings("unchecked")
	private <T> void checkMultiDimensionalCollection(final Collection<?> collection, Class<T> type) {
		assertEquals(2, collection.size(), "The generated List must have size=2!");
		Collection<?> subcollection = (Collection<?>)collection.iterator().next();
		assertEquals(2, subcollection.size(), "The generated List must have size=2!");
		subcollection = (Collection<?>)subcollection.iterator().next();
		assertEquals(2, subcollection.size(), "The generated List must have size=2!");
		T element = (T) subcollection.iterator().next();
		assertEquals(type, element.getClass(), "The generated List must be of " + type + "!");
	}

}
