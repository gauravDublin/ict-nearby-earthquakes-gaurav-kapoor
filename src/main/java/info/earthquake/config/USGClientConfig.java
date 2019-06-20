package info.earthquake.config;

import info.earthquake.infra.ConnectionConfigProps;
import info.earthquake.infra.USGClient;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@Configuration
public class USGClientConfig {
    private static final String PROPS_PREFIX = "usgs";

    @Bean
    public USGClient usgClient() {
        return new USGClient(webClient());
    }

    private WebClient webClient() {
        var props = usgsConnectionConfigProps();
        TcpClient tcpClient = TcpClient.create()
                .doOnConnected(connection ->
                        connection.addHandlerLast(new ReadTimeoutHandler(props.getReadTimeout())) // Read Timeout
                                .addHandlerLast(new WriteTimeoutHandler(props.getWriteTimeout()))); // Write Timeout
        return WebClient.builder()
                .baseUrl(props.getBaseUrl())
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .build();
    }

    @Bean
    @ConfigurationProperties(prefix = "client." + PROPS_PREFIX)
    ConnectionConfigProps usgsConnectionConfigProps() {
        return new ConnectionConfigProps();
    }
}