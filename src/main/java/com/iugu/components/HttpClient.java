package com.iugu.components;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.ClientRequestFilter;
import lombok.SneakyThrows;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public final class HttpClient {
    public static final int MAX_TOTAL_CONNECTIONS = Integer.parseInt(System.getProperty("iugu.http.max-connections", "300"));
    public static final int MAX_PER_ROUTE = Integer.parseInt(System.getProperty("iugu.http.max-per-route", "30"));

    public static Client getInstance() {
        return buildClient();
    }

    public static Client getInstance(ClientRequestFilter... filters) {
        Client client = buildClient();
        Optional.ofNullable(filters).map(Arrays::asList).orElseGet(ArrayList::new).forEach(client::register);
        return client;
    }

    @SneakyThrows
    private static SSLContext sslContext() {
        TrustManager[] noopTrustManager = new TrustManager[]{
                new X509TrustManager() {

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, noopTrustManager, null);
        return sc;
    }

    private static IuguResteasyJackson2Provider getResteasyJacksonProvider() {
        IuguResteasyJackson2Provider resteasyJacksonProvider = new IuguResteasyJackson2Provider();
        resteasyJacksonProvider.setMapper(Jackson.getInstance());
        return resteasyJacksonProvider;
    }

    private static Client buildClient() {
        return ((ResteasyClientBuilder) ClientBuilder.newBuilder())
                .sslContext(sslContext())
                .register(getResteasyJacksonProvider(), 100)
                .build();
    }
}
