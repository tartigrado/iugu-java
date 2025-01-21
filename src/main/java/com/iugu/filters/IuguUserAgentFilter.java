package com.iugu.filters;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.core.MultivaluedMap;
import org.apache.http.HttpHeaders;

import java.io.IOException;

public final class IuguUserAgentFilter implements ClientRequestFilter {
    private IuguUserAgentFilter() {

    }

    private static final class Holder {
        static IuguUserAgentFilter INSTANCE = new IuguUserAgentFilter();
    }

    public static IuguUserAgentFilter getInstance() {
        return Holder.INSTANCE;
    }


    private final static String USER_AGENT_NAME = System.getProperty("iugu.user-agent", "Tartigrado Iugu Java SDK");
    private final static String USER_AGENT_VERSION = System.getProperty("iugu.user-agent-version", "4.1.4");

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        MultivaluedMap<String, Object> headers = clientRequestContext.getHeaders();
        headers.add(HttpHeaders.USER_AGENT, USER_AGENT_NAME + "/" + USER_AGENT_VERSION);
    }


}
