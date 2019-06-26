package info.earthquake.domain;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

public class PropertyDTOTest {
    private static final Class<PropertyDTO> propertyDTOClass = PropertyDTO.class;

    @Test
    public void testPojo() {
        Assertions.assertPojoMethodsFor(propertyDTOClass).testing(Method.GETTER).areWellImplemented();
    }
}