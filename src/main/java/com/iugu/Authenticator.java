package com.iugu;

import lombok.Getter;
import org.apache.http.HttpHeaders;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

@Getter
public class Authenticator implements ClientRequestFilter {

    private final String user;
    private final String password;
    private final String token;

    public Authenticator(String iuguToken) {
        this(iuguToken, "");
    }

    public Authenticator(String user, String password) {
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
        return "Basic " + DatatypeConverter.printBase64Binary(token.getBytes(StandardCharsets.UTF_8));
    }
}