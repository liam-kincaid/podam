package uk.co.jemos.podam.test.unit.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import net.serenitybdd.annotations.Step;
import uk.co.jemos.podam.api.ClassAttribute;

import java.util.HashSet;
import java.util.Set;

/**
 * Validation steps for ClassInfo stories
 * Created by tedonema on 14/06/2015.
 */
public class ClassInfoValidationSteps {

    @Step("Then the attributes contains in ClassInfo should match the ones contains in the POJO")
    public void theClassInfoAttributesShouldMatchthePojoOnes(Set<String> attribs, Set<ClassAttribute> classAttributes) {

        Set<String> missingAttribs = new HashSet<String>(attribs);
        for (ClassAttribute attribute : classAttributes) {
            String attrName = attribute.getName();
            assertTrue(missingAttribs.contains(attrName), "Unexpected attribute");
            missingAttribs.remove(attrName);
            assertEquals(1, attribute.getGetters().size(), "Wrong number of getters for " + attribute.getName());
            assertEquals(1, attribute.getSetters().size(), "Wrong number of setters for " + attribute.getName());
        }
        assertTrue(missingAttribs.isEmpty(), "Missing attributes");
    }

}
