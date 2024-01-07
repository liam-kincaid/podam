package uk.co.jemos.podam.test.unit.steps;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import net.serenitybdd.annotations.Step;

import uk.co.jemos.podam.api.AbstractClassInfoStrategy;
import uk.co.jemos.podam.api.AttributeMetadata;
import uk.co.jemos.podam.api.ClassAttributeApprover;
import uk.co.jemos.podam.api.ClassInfo;
import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.common.ManufacturingContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by tedonema on 27/05/2015.
 */
public class PodamInvocationSteps {

    private AbstractClassInfoStrategy classInfoStrategy = new AbstractClassInfoStrategy() {};

    @Step("When I invoke the factory manufacturing for {0}")
    public <T> T whenIInvokeTheFactoryForClass(Class<T> className, PodamFactory podamFactory) throws Exception {
        return podamFactory.manufacturePojo(className);
    }

    @Step("When I invoke the pojo's population directly for {0}")
    public <T> T whenIInvokeThePojoPopulationDirectly(T pojo, PodamFactory podamFactory) throws Exception {
        return podamFactory.populatePojo(pojo);
    }

    @Step("When I invoke the factory to manufacture {0} with the fullest constructor")
    public <T> T whenIInvokeTheFactoryForClassWithFullConstructor(Class<T> className, PodamFactory podamFactory)
    throws Exception {
        return podamFactory.manufacturePojoWithFullData(className);
    }

    @Step("When I invoke a method to get class info for class {0} and approver {1}")
    public ClassInfo getClassInfo(Class<?> pojoClass, ClassAttributeApprover approver) {
        return classInfoStrategy.getClassInfo(pojoClass,
                new HashSet<Class<? extends Annotation>>(),
                Collections.<String>emptySet(), approver,
                Collections.<Method>emptySet());
    }

    @Step("When I invoke a method to get class info for class {0} with a custom class strategy {1} and approver {2}")
    public ClassInfo getClassInfoWithCustomClassStrategy(Class<?> pojoClass,
            AbstractClassInfoStrategy classStrategy, ClassAttributeApprover approver) {
        return classStrategy.getClassInfo(pojoClass,
                new HashSet<Class<? extends Annotation>>(),
                Collections.<String>emptySet(), approver,
                Collections.<Method>emptySet());
    }

    @Step("When I invoke the factory manufacturing for {0} with specific types {2}")
    public <T> T whenIInvokeTheFactoryForGenericTypeWithSpecificType(
            Class<T> pojoClass,
            PodamFactory podamFactory, Type... genericTypeArgs) {
        return podamFactory.manufacturePojo(pojoClass, genericTypeArgs);
    }

    @Step("When I clear memoization cache")
    public void whenIClearMemoizationCache(PodamFactory podamFactory) {
        podamFactory.getStrategy().clearMemoizationCache();
    }

    @Step("When I remove a type manufacturer for a type {1}")
    public void whenIRemoveTypeManufacturer(PodamFactory podamFactory, Class<?> type) {
        podamFactory.getStrategy().removeTypeManufacturer(type);
    }

    @Step("When I request a value for a type {3}")
    public Object whenISendAMessageToTheChannel(DataProviderStrategy strategy,
			AttributeMetadata attributeMetadata,
			ManufacturingContext manufacturingCtx,
			Class<?> type) {

        Object payload = strategy.getTypeValue(attributeMetadata,
                manufacturingCtx, type);
        assertNotNull(payload, "Payload must be valid");
        return payload;
    }
}
