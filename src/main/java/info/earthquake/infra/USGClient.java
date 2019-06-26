package info.earthquake.infra;

import info.earthquake.domain.EarthQuakeInfoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

import static java.util.Objects.requireNonNull;

public class USGClient {

    private final WebClient webClient;

    @Value("${client.usgs.data}")
    private String PATH_EARTHQUAKES;

    public USGClient(WebClient webClient) {
        this.webClient = requireNonNull(webClient);
    }

    public EarthQuakeInfoResponse findEarthQuakeData() {
        return webClient
                .get()
                .uri(PATH_EARTHQUAKES)
                .retrieve()
                .bodyToMono(EarthQuakeInfoResponse.class)
                .block();
    }
}

