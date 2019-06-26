package info.earthquake.domain;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

public class MetaDataDTOTest {
    private static final Class<MetaDataDTO> metaDataDTOClass = MetaDataDTO.class;

    @Test
    public void testPojo() {
        Assertions.assertPojoMethodsFor(metaDataDTOClass).testing(Method.GETTER).areWellImplemented();
    }
}