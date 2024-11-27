package com.iugu.components;

import com.iugu.IuguConstants;
import com.iugu.filters.IuguLanguageFilter;
import com.iugu.filters.IuguUserAgentFilter;
import com.iugu.utils.UriUtils;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientRequestFilter;
import lombok.SneakyThrows;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public final class HttpClientManager {
    public static final int MAX_TOTAL_CONNECTIONS = Integer.parseInt(System.getProperty("iugu.http.max-connections", "300"));
    public static final int MAX_PER_ROUTE = Integer.parseInt(System.getProperty("iugu.http.max-per-route", "30"));
    private static final PoolingHttpClientConnectionManager connectionManager;
    private static final CloseableHttpClient httpClient;
    private static final Client client;

    @SneakyThrows
    private static SSLContext sslContext() {
        TrustManager[] noopTrustManager = new TrustManager[]{
                new X509TrustManager() {

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, noopTrustManager, null);
        return sc;
    }

    public static ResteasyClient client() {
        return (ResteasyClient) client;
    }

    public static ResteasyWebTarget target(ClientRequestFilter... filters) {
        ResteasyWebTarget target = ((ResteasyClient) client).target(UriUtils.createURI(IuguConstants.BASE_URL_API));
        Optional.ofNullable(filters).map(Arrays::asList).orElseGet(ArrayList::new).forEach(target::register);
        target.register(IuguUserAgentFilter.getInstance());
        target.register(IuguLanguageFilter.getInstance());
        return target;
    }

    public static <T> T proxy(Class<T> proxy, ClientRequestFilter... filters) {
        ResteasyWebTarget target = target(filters);
        return target.proxy(proxy);
    }

    static {
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MAX_TOTAL_CONNECTIONS); // Maximum total connections
        connectionManager.setDefaultMaxPerRoute(MAX_PER_ROUTE); // Maximum connections per route

        // Initialize the HttpClient with the connection manager
        httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .build();

        client = ResteasyClientBuilder
                .newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .sslContext(sslContext())
                .register(IuguResteasyJackson2Provider.class, 100)
                .build();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                close();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }));
    }

    public static void close() throws IOException {
        if (connectionManager != null) {
            connectionManager.close();
        }
        if (httpClient != null) {
            httpClient.close();
        }
    }
}


