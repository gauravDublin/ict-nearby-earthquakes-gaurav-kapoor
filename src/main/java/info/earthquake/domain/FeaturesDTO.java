package info.earthquake.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeaturesDTO {
    private final FeatureDTO feature;

    @JsonCreator
    public FeaturesDTO(FeatureDTO feature) {
        this.feature = feature;
    }

    public FeatureDTO getFeature() {
        return feature;
    }
}
