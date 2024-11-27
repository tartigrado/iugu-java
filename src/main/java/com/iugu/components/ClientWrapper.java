package com.iugu.components;

import com.iugu.filters.IuguLanguageFilter;
import com.iugu.filters.IuguUserAgentFilter;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.UriBuilder;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
public final class ClientWrapper implements Client {
    private final ResteasyClient client;
    private final ClientRequestFilter filter;

    @Override
    public void close() {

    }

    @Override
    public WebTarget target(String s) {
        ResteasyWebTarget target = client.target(s).register(IuguUserAgentFilter.getInstance()).register(IuguLanguageFilter.getInstance());
        if (Objects.nonNull(filter)) {
            target = target.register(filter);
        }
        return target;
    }

    @Override
    public WebTarget target(URI uri) {
        ResteasyWebTarget target = client.target(uri).register(IuguUserAgentFilter.getInstance()).register(IuguLanguageFilter.getInstance());
        if (Objects.nonNull(filter)) {
            target = target.register(filter);
        }
        return target;
    }

    @Override
    public WebTarget target(UriBuilder uriBuilder) {
        ResteasyWebTarget target = client.target(uriBuilder).register(IuguUserAgentFilter.getInstance()).register(IuguLanguageFilter.getInstance());
        if (Objects.nonNull(filter)) {
            target = target.register(filter);
        }
        return target;
    }

    @Override
    public WebTarget target(Link link) {
        ResteasyWebTarget target = client.target(link).register(IuguUserAgentFilter.getInstance()).register(IuguLanguageFilter.getInstance());
        if (Objects.nonNull(filter)) {
            target = target.register(filter);
        }
        return target;
    }

    @Override
    public Invocation.Builder invocation(Link link) {
        return null;
    }

    @Override
    public SSLContext getSslContext() {
        return null;
    }

    @Override
    public HostnameVerifier getHostnameVerifier() {
        return null;
    }

    @Override
    public Configuration getConfiguration() {
        return null;
    }

    @Override
    public Client property(String s, Object o) {
        return null;
    }

    @Override
    public Client register(Class<?> aClass) {
        return null;
    }

    @Override
    public Client register(Class<?> aClass, int i) {
        return null;
    }

    @Override
    public Client register(Class<?> aClass, Class<?>... classes) {
        return null;
    }

    @Override
    public Client register(Class<?> aClass, Map<Class<?>, Integer> map) {
        return null;
    }

    @Override
    public Client register(Object o) {
        return null;
    }

    @Override
    public Client register(Object o, int i) {
        return null;
    }

    @Override
    public Client register(Object o, Class<?>... classes) {
        return null;
    }

    @Override
    public Client register(Object o, Map<Class<?>, Integer> map) {
        return null;
    }
}
