package info.earthquake.domain;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

public class GeometryDTOTest {
    private static final Class<GeometryDTO> geometryDTOClass = GeometryDTO.class;

    @Test
    public void testPojo() {
        Assertions.assertPojoMethodsFor(geometryDTOClass).testing(Method.GETTER).areWellImplemented();
    }
}