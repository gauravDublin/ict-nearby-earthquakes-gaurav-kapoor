package info.earthquake.domain;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

public class LocationTest {
    private static final Class<Location> locationClass = Location.class;

    @Test
    public void testPojo() {
        Assertions.assertPojoMethodsFor(locationClass).testing(Method.GETTER).areWellImplemented();
    }
}