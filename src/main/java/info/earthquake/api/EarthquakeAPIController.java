package info.earthquake.api;

import info.earthquake.infra.USGClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class EarthquakeAPIController implements EarthquakeAPI {

    @Autowired
    private USGClient client;

    @Override
    public Mono<String> getEarthQuakeResponse() {
        return client.findEarthQuakeData();
    }
}
