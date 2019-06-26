package info.earthquake.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:msg.properties")
public class ConsoleConfig {
    @Value("${app.earthquake.welcome-msg}")
    private String welcomeMessage;

    @Value("${app.earthquake.wait-msg}")
    private String waitingMessage;

    @Value("${app.earthquake.invalid.double}")
    private String propInvalidDouble;

    @Value("${app.earthquake.line.separator.dash}")
    private String dashLine;

    @Value("${app.earthquake.meta.header}")
    private String top10;

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String getPropInvalidDouble() {
        return propInvalidDouble;
    }

    public String getWaitingMessage() {
        return waitingMessage;
    }

    public String getDashLine() {
        return dashLine;
    }

    public String getTop10() {
        return top10;
    }
}
