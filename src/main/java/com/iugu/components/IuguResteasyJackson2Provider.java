package com.iugu.components;

import org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider;

public final class IuguResteasyJackson2Provider extends ResteasyJackson2Provider {
    public IuguResteasyJackson2Provider() {
        super();
        setMapper(Jackson.getInstance());
    }
}
