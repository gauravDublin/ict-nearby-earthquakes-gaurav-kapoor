package info.earthquake.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static info.earthquake.infra.HttpResponses.requireOkOrError;
import static java.util.Objects.requireNonNull;

public class USGClient {

    private final WebClient webClient;

    @Value("${client.usgs.data}")
    private String PATH_EARTHQUAKES;

    public USGClient(WebClient webClient) {
        this.webClient = requireNonNull(webClient);
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