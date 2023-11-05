package com.iugu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.iugu.components.ClientWrapper;
import com.iugu.components.IuguResteasyJackson2Provider;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.security.cert.X509Certificate;

public class IuguConfiguration {

    private final static String URL = "https://api.iugu.com/v1";
    private final String tokenId;

    public IuguConfiguration(String token) {
        tokenId = token;
    }

    public static String url(String endpoint) {
        return URL + endpoint;
    }

    private IuguResteasyJackson2Provider getResteasyJacksonProvider() {
        IuguResteasyJackson2Provider resteasyJacksonProvider = new IuguResteasyJackson2Provider();
        resteasyJacksonProvider.setMapper(JsonMapper
                .builder()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .serializationInclusion(JsonInclude.Include.NON_EMPTY)
                .build());
        return resteasyJacksonProvider;
    }

    public ClientWrapper getNewClient() {
        return new ClientWrapper(getNewClientNotAuth().register(new Authenticator(tokenId)));
    }

    public ClientWrapper getNewClientNotAuth() {
        return new ClientWrapper(ResteasyClientBuilder.newBuilder().sslContext(getContext()).register(getResteasyJacksonProvider(), 100).build());
    }

    public SSLContext getContext() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}