package info.earthquake.infra;

import java.net.URL;

/**
 * Stores configuration to connect to the provider server
 */
public class ConnectionConfigProps {

    /**
     * Full endpoint schema including protocol, no trailing slash (e.g. https://localhost:1234)
     */
    protected String baseUrl;

    /**
     * Time in in seconds until a connection is established.
     */
    protected Integer connectTimeout;

    /**
     * If no data was read within a readTimeout (sec) period, the connection will fail
     */
    protected Integer readTimeout;

    /**
     * Ifa write operation cannot finish in a writeTimeout (sec) period, the connection will fail
     */
    protected Integer writeTimeout;

    protected URL keystore;

    protected String keystorePassword;

    protected String proxyHost;

    protected Integer proxyPort;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
    }

    public Integer getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(Integer writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    public URL getKeystore() {
        return keystore;
    }

    public void setKeystore(URL keystore) {
        this.keystore = keystore;
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public void setKeystorePassword(String keystorePassword) {
        this.keystorePassword = keystorePassword;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public Integer getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }
}
