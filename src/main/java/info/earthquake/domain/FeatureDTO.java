package info.earthquake.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeatureDTO {

    private final String type;
    private final PropertyDTO properties;
    private final GeometryDTO geometry;
    private final String id;

    @JsonCreator
    public FeatureDTO(@JsonProperty("type") String type, @JsonProperty("properties") PropertyDTO properties,
                      @JsonProperty("geometry") GeometryDTO geometry, @JsonProperty("id") String id) {
        this.type = type;
        this.properties = properties;
        this.geometry = geometry;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public PropertyDTO getProperties() {
        return properties;
    }

    public GeometryDTO getGeometry() {
        return geometry;
    }

    public String getId() {
        return id;
    }
}
