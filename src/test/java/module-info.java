module podam.test {

	requires com.serenitybdd.serenityjunit5; //
    requires com.serenitybdd.serenitymodel; //
	requires jakarta.activation;
    requires jakarta.annotation;
	requires jakarta.persistence;
    requires jakarta.validation;
	requires jakarta.xml.bind;
    requires java.desktop;
    requires java.sql;
    requires java.xml;
    requires jcip.annotations; //
    requires org.apache.commons.lang3; //
	requires org.hibernate.validator; //
    requires org.junit.jupiter.api;
    requires org.junit.platform.commons;
    requires org.openapitools.jackson.nullable; //
    requires org.slf4j;
	requires net.bytebuddy;
    requires podam;
    requires static lombok;

    opens uk.co.jemos.podam.test.dto.annotations to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.dto to java.base, jakarta.persistence, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.dto.docs.example to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.dto.issue123 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.dto.issue323 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.dto.pdm3 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.dto.pdm4 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.dto.pdm5 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.dto.pdm6 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.dto.pdm33 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.dto.pdm42 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.dto.pdm43 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.dto.pdm45 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.integration to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.strategies to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.annotations to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.basicTypes to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.classInfo to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.collections to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.constructors to java.base, java.desktop, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.dataProviderStrategy to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.edgeCases to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.extensions to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.externalFactory to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.factories to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.inheritance to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.memoization to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.randomness to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.singletons to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.typeManufacturing to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.validatorFramework to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.walkThroughExample to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.features.xmlTypes to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.issue86 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.issue93 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.issue323 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.pdm3 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.pdm4 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.pdm5 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.pdm43 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.pdm45 to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit.steps to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.unit to java.base, org.junit.platform.commons;
    opens uk.co.jemos.podam.test.utils to java.base, org.junit.platform.commons;
}
