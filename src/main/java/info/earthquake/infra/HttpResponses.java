package info.earthquake.infra;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

public final class HttpResponses {

    private HttpResponses() {
        throw new AssertionError("No instance for you :(");
    }

    public static boolean isSuccessful(HttpStatus status) {
        return isSuccessful(status.value());
    }

    public static boolean isSuccessful(int code) {
        return code >= 200 && code < 300;
    }

    public static boolean isNotSuccessful(HttpStatus status) {
        return isNotSuccessful(status.value());
    }

    public static boolean isNotSuccessful(int code) {
        return !isSuccessful(code);
    }

    public static Mono<ClientResponse> requireOkOrError(ClientResponse response, String msg) {
        if (isNotSuccessful(response.statusCode())) {
            return Mono.error(new HttpNetworkException(response.rawStatusCode(), msg));
        }

        return Mono.just(response);
    }
}

