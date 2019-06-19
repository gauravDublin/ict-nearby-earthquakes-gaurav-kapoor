package info.earthquake.infra;

import info.earthquake.domain.EarthQuakeInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static info.earthquake.infra.HttpResponses.requireOkOrError;

@Service
public class USGClient {

    private final WebClient webClient;
    private static final String PATH_EARTHQUAKES = "/earthquakes/feed/v1.0/summary/all_month.geojson";

    @Autowired
    public USGClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://earthquake.usgs.gov").build();
    }

    public Mono<String> findEarthQuakeData() { ;
        return webClient
                .get()
                .uri(PATH_EARTHQUAKES)
                .exchange()
                .flatMap(res -> requireOkOrError(res, "Failed to fetch USG events"))
                .flatMap(response -> response.bodyToMono(String.class));
    }

}