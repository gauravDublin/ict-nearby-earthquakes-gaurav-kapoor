package info.earthquake.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetaDataDTO {
    private final Long generated;
    private final String url;
    private final String title;
    private final String api;
    private final Integer count;
    private final Integer status;

    @JsonCreator
    public MetaDataDTO(@JsonProperty("generated") Long generated, @JsonProperty("url") String url,
                       @JsonProperty("title") String title, @JsonProperty("api") String api,
                       @JsonProperty("count") Integer count, @JsonProperty("status") Integer status) {
        this.generated = generated;
        this.url = url;
        this.title = title;
        this.api = api;
        this.count = count;
        this.status = status;
    }

}
