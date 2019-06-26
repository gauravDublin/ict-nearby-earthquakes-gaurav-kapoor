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

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String getPropInvalidDouble() {
        return propInvalidDouble;
    }

    public String getWaitingMessage() {
        return waitingMessage;
    }
}
