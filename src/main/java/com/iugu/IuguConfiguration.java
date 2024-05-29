package com.iugu;

import com.iugu.components.ClientWrapper;
import com.iugu.components.IuguResteasyJackson2Provider;
import com.iugu.components.Jackson;
import com.iugu.interfaces.PrivateKeyProvider;
import com.iugu.interfaces.WithApiToken;
import com.iugu.model.generic.SignedBody;
import lombok.SneakyThrows;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Optional;

public class IuguConfiguration {

    private final static String URL = "https://api.iugu.com/v1";
    private final String tokenId;
    private final PrivateKeyProvider keyProvider;

    public IuguConfiguration() {
        this(null);
    }

    public IuguConfiguration(String token) {
        this(token, null);
    }

    public IuguConfiguration(String token, PrivateKeyProvider keyProvider) {
        this.tokenId = token;
        this.keyProvider = keyProvider;
    }

    public static String url(String endpoint) {
        return URL + endpoint;
    }

    public static String baseUrl(String endpoint) {
        return "/v1" + endpoint;
    }

    public <T extends WithApiToken> T withToken(T obj) {
        obj.setApiToken(tokenId);
        return obj;
    }

    @SneakyThrows
    public SignedBody signBody(Object body, String method, String endpoint) {
        body = Optional.ofNullable(body).orElseThrow(() -> new IllegalArgumentException("body is required."));
        method = Optional.ofNullable(method).orElseThrow(() -> new IllegalArgumentException("method is required.")).toUpperCase();
        endpoint = Optional.ofNullable(endpoint).orElseThrow(() -> new IllegalArgumentException("method is required."));
        PrivateKey key = Optional.ofNullable(this.keyProvider).orElseThrow(() -> new IllegalArgumentException("key provider is null")).getPrivateKey();
        return SignedBody
                .builder()
                .body(body instanceof String ? (String) body : Jackson.getInstance().writeValueAsString(body))
                .endpoint(endpoint)
                .method(method)
                .build()
                .sign(Optional.ofNullable(this.tokenId).orElseThrow(() -> new IllegalArgumentException("token id is null")), key);
    }

    private IuguResteasyJackson2Provider getResteasyJacksonProvider() {
        IuguResteasyJackson2Provider resteasyJacksonProvider = new IuguResteasyJackson2Provider();
        resteasyJacksonProvider.setMapper(Jackson.getInstance());
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
            return null;
        }

    }

}