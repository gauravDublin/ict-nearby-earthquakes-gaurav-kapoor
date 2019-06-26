package info.earthquake.domain;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

public class FeaturesDTOTest {
    private static final Class<FeaturesDTO> featuresDTOClass = FeaturesDTO.class;

    @Test
    public void testPojo() {
        Assertions.assertPojoMethodsFor(featuresDTOClass).testing(Method.GETTER).areWellImplemented();
    }
}