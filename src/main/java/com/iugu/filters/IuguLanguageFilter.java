package com.iugu.filters;

import com.iugu.IuguConstants;
import com.iugu.utils.UriUtils;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;

import java.io.IOException;
import java.util.Map;

public final class IuguLanguageFilter implements ClientRequestFilter {

    private static final class Holder {
        static IuguLanguageFilter INSTANCE = new IuguLanguageFilter();
    }

    public static IuguLanguageFilter getInstance() {
        return Holder.INSTANCE;
    }

    private IuguLanguageFilter() {

    }

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        clientRequestContext.setUri(UriUtils.createURI(clientRequestContext.getUri().toString(), Map.of("language", IuguConstants.LOCALE, "hl", IuguConstants.LOCALE)));
    }

}
