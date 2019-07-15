package info.earthquake.config;

import info.earthquake.domain.EarthQuakeInfoResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class USGClientConfig {
    private String restUrl = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson";
    RestTemplate restTemplate = new RestTemplate();

    @Bean
    public EarthQuakeInfoResponse getRestTemplate() {
        return restTemplate.getForObject(restUrl, EarthQuakeInfoResponse.class);
    }

}