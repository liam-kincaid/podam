/**
 *
 */
package uk.co.jemos.podam.test.dto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmbeddedAbstractFieldTestPojo {

	private final AbstractTestPojo testPojo;

	public EmbeddedAbstractFieldTestPojo(final AbstractTestPojo pojo) {
		assertNotNull(pojo);
		testPojo = pojo;
	}

	public AbstractTestPojo getPojo() {
		return testPojo;
	}

}
