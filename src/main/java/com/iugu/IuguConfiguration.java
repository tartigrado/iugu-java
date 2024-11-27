package com.iugu;

import com.iugu.components.ClientWrapper;
import com.iugu.components.HttpClientManager;
import com.iugu.components.Jackson;
import com.iugu.filters.AuthenticatorFilter;
import com.iugu.interfaces.PrivateKeyProvider;
import com.iugu.interfaces.WithApiToken;
import com.iugu.model.generic.SignedBody;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientRequestFilter;
import lombok.SneakyThrows;

import java.security.PrivateKey;
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

    public ClientRequestFilter authenticator() {
        return new AuthenticatorFilter(tokenId);
    }

    public Client getNewClient() {
        return new ClientWrapper(HttpClientManager.client(), authenticator());
    }

    public Client getNewClientNotAuth() {
        return new ClientWrapper(HttpClientManager.client(), null);
    }

}