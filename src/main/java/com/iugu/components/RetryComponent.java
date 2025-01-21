package com.iugu.components;


import jakarta.ws.rs.WebApplicationException;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

@RequiredArgsConstructor
public final class RetryComponent {
    public static RetryComponent getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        static RetryComponent INSTANCE = new RetryComponent();
    }

    private final int maxRetries;
    private final long retryDelayMillis;
    private final Set<Integer> retryableStatusCodes;


    private RetryComponent() {
        this(3, 1000, Set.of(500, 502, 503, 504));
    }

    public <T> T retry(Supplier<T> supplier) {
        int attempt = 0;
        WebApplicationException lastEx = null;
        while (attempt++ < maxRetries) {
            try {
                return supplier.get();
            } catch (WebApplicationException ex) {
                if (attempt >= maxRetries || !retryableStatusCodes.contains(ex.getResponse().getStatus())) {
                    throw ex;
                }
                lastEx = ex;
            }

            try {
                Thread.sleep(retryDelayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Retry process was interrupted", e);
            }
        }
        throw Objects.isNull(lastEx) ? new RuntimeException("Max retries exceeded") : lastEx;
    }

}
