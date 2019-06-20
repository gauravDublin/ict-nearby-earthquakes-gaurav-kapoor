package info.earthquake.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@Validated
public interface  EarthquakeAPI {

    @GetMapping(value = "/events")
    Mono<String> getEarthQuakeResponse();
}
