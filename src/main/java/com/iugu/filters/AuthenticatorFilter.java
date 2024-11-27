package com.iugu.filters;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.core.MultivaluedMap;
import lombok.Getter;
import org.apache.http.HttpHeaders;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Getter
public final class AuthenticatorFilter implements ClientRequestFilter {

    private final String user;
    private final String password;
    private final String token;

    public AuthenticatorFilter(String iuguToken) {
        this(iuguToken, "");
    }

    public AuthenticatorFilter(String user, String password) {
        this.user = user;
        this.password = password;
        this.token = getBasicAuthentication();
    }

    public void filter(ClientRequestContext requestContext) {
        MultivaluedMap<String, Object> headers = requestContext.getHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, token);
    }

    private String getBasicAuthentication() {
        String token = getUser() + ":" + getPassword();
        return "Basic " + Base64.getUrlEncoder().encodeToString(token.getBytes(StandardCharsets.UTF_8));
    }
}