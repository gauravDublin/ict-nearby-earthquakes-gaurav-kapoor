package info.earthquake.infra;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

@Failure("00012")
public class HttpNetworkException extends NetworkException {

    private final Integer code;

    public HttpNetworkException(Integer code, String message) {
        super(message);
        this.code = requireNonNull(code);
    }

    public HttpNetworkException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = requireNonNull(code);
    }

    public HttpNetworkException(Integer code, Throwable cause) {
        super(cause);
        this.code = requireNonNull(code);
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return format("%s: %s (status code = %d)", getClass().getName(), getMessage(), code);
    }
}
