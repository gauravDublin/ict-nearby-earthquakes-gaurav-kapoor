package info.earthquake.domain;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

public class EarthQuakeInfoResponseTest {
    private static final Class<EarthQuakeInfoResponse> earthQuakeInfoResponseClass = EarthQuakeInfoResponse.class;

    @Test
    public void testPojo() {
        Assertions.assertPojoMethodsFor(earthQuakeInfoResponseClass).testing(Method.GETTER).areWellImplemented();
    }
}