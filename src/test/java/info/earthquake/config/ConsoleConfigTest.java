package info.earthquake.config;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

public class ConsoleConfigTest {
    private final Class<ConsoleConfig> classUnderTest = ConsoleConfig.class;

    @Test
    public void pojoTest() {
        Assertions.assertPojoMethodsFor(classUnderTest).testing(Method.GETTER).areWellImplemented();
    }
}