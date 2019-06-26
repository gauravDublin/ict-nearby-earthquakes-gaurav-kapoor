package info.earthquake.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropertyDTO {
    private final Double mag;
    private final String place;
    private final Long time;
    private final Long updated;
    private final Integer tz;
    private final String url;
    private final String detail;
    private final Double felt;
    private final Double cdi;
    private final Double mmi;
    private final String alert;
    private final String status;
    private final Integer tsunami;
    private final Integer sig;
    private final String net;
    private final String code;
    private final String ids;
    private final String sources;
    private final String types;
    private final Integer nst;
    private final Double dmin;
    private final Double rms;
    private final Integer gap;
    private final String magType;
    private final String type;
    private final String title;

    public PropertyDTO(@JsonProperty("mag") Double mag, @JsonProperty("place") String place, @JsonProperty("time") Long time,
                       @JsonProperty("updated") Long updated, @JsonProperty("tz")  Integer tz, @JsonProperty("url") String url,
                       @JsonProperty("detail") String detail, @JsonProperty("felt") Double felt, @JsonProperty("cdi") Double cdi,
                       @JsonProperty("mmi") Double mmi, @JsonProperty("alert") String alert,
                       @JsonProperty("status") String status, @JsonProperty("tsunami") Integer tsunami,
                       @JsonProperty("sig") Integer sig, @JsonProperty("net") String net, @JsonProperty("code") String code,
                       @JsonProperty("ids") String ids, @JsonProperty("sources") String sources, @JsonProperty("types") String types,
                       @JsonProperty("nst") Integer nst, @JsonProperty("dmin") Double dmin, @JsonProperty("rms") Double rms,
                       @JsonProperty("gap") Integer gap, @JsonProperty("magType") String magType,
                       @JsonProperty("type") String type, @JsonProperty("title") String title) {
        this.mag = mag;
        this.place = place;
        this.time = time;
        this.updated = updated;
        this.tz = tz;
        this.url = url;
        this.detail = detail;
        this.felt = felt;
        this.cdi = cdi;
        this.mmi = mmi;
        this.alert = alert;
        this.status = status;
        this.tsunami = tsunami;
        this.sig = sig;
        this.net = net;
        this.code = code;
        this.ids = ids;
        this.sources = sources;
        this.types = types;
        this.nst = nst;
        this.dmin = dmin;
        this.rms = rms;
        this.gap = gap;
        this.magType = magType;
        this.type = type;
        this.title = title;
    }

    public Double getMag() {
        return mag;
    }

    public String getPlace() {
        return place;
    }

    public Long getTime() {
        return time;
    }

    public Long getUpdated() {
        return updated;
    }

    public Integer getTz() {
        return tz;
    }

    public String getUrl() {
        return url;
    }

    public String getDetail() {
        return detail;
    }

    public Double getFelt() {
        return felt;
    }

    public Double getCdi() {
        return cdi;
    }

    public Double getMmi() {
        return mmi;
    }

    public String getAlert() {
        return alert;
    }

    public String getStatus() {
        return status;
    }

    public Integer getTsunami() {
        return tsunami;
    }

    public Integer getSig() {
        return sig;
    }

    public String getNet() {
        return net;
    }

    public String getCode() {
        return code;
    }

    public String getIds() {
        return ids;
    }

    public String getSources() {
        return sources;
    }

    public String getTypes() {
        return types;
    }

    public Integer getNst() {
        return nst;
    }

    public Double getDmin() {
        return dmin;
    }

    public Double getRms() {
        return rms;
    }

    public Integer getGap() {
        return gap;
    }

    public String getMagType() {
        return magType;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }
}
