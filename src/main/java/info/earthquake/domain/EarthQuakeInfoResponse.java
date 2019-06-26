package info.earthquake.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EarthQuakeInfoResponse {
    private final String type;
    private final MetaDataDTO metadata;
    private final List<FeaturesDTO> features;
    private final List<Double> bbox;

    @JsonCreator
    public EarthQuakeInfoResponse(@JsonProperty("type") String type, @JsonProperty("metadata") MetaDataDTO metaDataDTO,
                                  @JsonProperty("features") List<FeaturesDTO> features,
                                  @JsonProperty("bbox") List<Double> bbox) {
        this.type = type;
        this.metadata = metaDataDTO;
        this.features = features;
        this.bbox = bbox;
    }

    public String getType() {
        return type;
    }

    public MetaDataDTO getMetadata() {
        return metadata;
    }

    public List<FeaturesDTO> getFeatures() {
        return features;
    }

    public List<Double> getBbox() {
        return bbox;
    }
}
