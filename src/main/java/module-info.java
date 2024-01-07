module podam {
    exports uk.co.jemos.podam.api;
    exports uk.co.jemos.podam.common;
    exports uk.co.jemos.podam.exceptions;
    exports uk.co.jemos.podam.typeManufacturers;

    requires jakarta.validation;
    requires java.base;
    requires jcip.annotations;
    requires org.apache.commons.lang3;
    requires org.slf4j;

    opens uk.co.jemos.podam.api to java.base;
}
