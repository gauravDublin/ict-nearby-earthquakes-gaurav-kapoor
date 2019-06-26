package info.earthquake.domain;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

public class EarthquakePointTest {
    private static final Class<EarthquakePoint> earthquakePointClass = EarthquakePoint.class;

    @Test
    public void testPojo() {
        Assertions.assertPojoMethodsFor(earthquakePointClass).testing(Method.GETTER).areWellImplemented();
    }
}