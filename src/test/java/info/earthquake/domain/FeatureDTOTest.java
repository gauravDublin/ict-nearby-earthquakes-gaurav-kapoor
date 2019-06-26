package info.earthquake.domain;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

public class FeatureDTOTest {

    private static final Class<FeatureDTO> featureDTOClass = FeatureDTO.class;
    @Test
    public void testPojo() {
        Assertions.assertPojoMethodsFor(featureDTOClass).testing(Method.GETTER).areWellImplemented();
    }
}