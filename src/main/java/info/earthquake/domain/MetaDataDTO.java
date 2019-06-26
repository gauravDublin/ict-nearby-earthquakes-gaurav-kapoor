package info.earthquake.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
                       @JsonProperty("title") String title,  @JsonProperty("status") Integer status,
                       @JsonProperty("api") String api, @JsonProperty("count") Integer count) {
        this.generated = generated;
        this.url = url;
        this.title = title;
        this.status = status;
        this.api = api;
        this.count = count;
    }

    public Long getGenerated() {
        return generated;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getApi() {
        return api;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getStatus() {
        return status;
    }
}
