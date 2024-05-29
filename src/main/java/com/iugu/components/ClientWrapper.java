package com.iugu.components;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriBuilder;
import java.io.Closeable;
import java.net.URI;
import java.util.Map;

@AllArgsConstructor
@Getter
public final class ClientWrapper implements Closeable, Client {

    private final Client client;

    @Override
    public void close() {
        getClient().close();
    }

    @Override
    public WebTarget target(String s) {
        return getClient().target(s);
    }

    @Override
    public WebTarget target(URI uri) {
        return getClient().target(uri);
    }

    @Override
    public WebTarget target(UriBuilder uriBuilder) {
        return getClient().target(uriBuilder);
    }

    @Override
    public WebTarget target(Link link) {
        return getClient().target(link);
    }

    @Override
    public Invocation.Builder invocation(Link link) {
        return getClient().invocation(link);
    }

    @Override
    public SSLContext getSslContext() {
        return getClient().getSslContext();
    }

    @Override
    public HostnameVerifier getHostnameVerifier() {
        return getClient().getHostnameVerifier();
    }

    @Override
    public Configuration getConfiguration() {
        return getClient().getConfiguration();
    }

    @Override
    public Client property(String s, Object o) {
        return getClient().property(s, o);
    }

    @Override
    public Client register(Class<?> aClass) {
        return getClient().register(aClass);
    }

    @Override
    public Client register(Class<?> aClass, int i) {
        return getClient().register(aClass, i);
    }

    @Override
    public Client register(Class<?> aClass, Class<?>... classes) {
        return getClient().register(aClass, classes);
    }

    @Override
    public Client register(Class<?> aClass, Map<Class<?>, Integer> map) {
        return getClient().register(aClass, map);
    }

    @Override
    public Client register(Object o) {
        return getClient().register(o);
    }

    @Override
    public Client register(Object o, int i) {
        return getClient().register(o, i);
    }

    @Override
    public Client register(Object o, Class<?>... classes) {
        return getClient().register(o, classes);
    }

    @Override
    public Client register(Object o, Map<Class<?>, Integer> map) {
        return getClient().register(o, map);
    }
}
