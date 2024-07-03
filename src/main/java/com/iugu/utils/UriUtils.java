package com.iugu.utils;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class UriUtils {
    private UriUtils() {
        throw new UnsupportedOperationException("no URIUtils instances for you");
    }

    public static URI createURI(String url) {
        return createURI(url, new HashMap<>());
    }

    public static URI createURI(String url, Map<String, Object> params) {
        URIBuilder builder = new URIBuilder(URI.create(url));

        if (Objects.nonNull(params) && !params.isEmpty()) {
            params.forEach((k, v) -> builder.addParameter(k, String.valueOf(v)));
        }

        try {
            return builder.build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
