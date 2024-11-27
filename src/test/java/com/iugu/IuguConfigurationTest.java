package com.iugu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IuguConfigurationTest {

    @Test
    public void testGetUrl() {
        Assertions.assertEquals("https://api.iugu.com/v1/transfers", IuguConfiguration.url("/transfers"));
    }

    @Test
    public void testGetBaseUrl() {
        Assertions.assertEquals("/v1/transfers", IuguConfiguration.baseUrl("/transfers"));
    }

    @Test
    public void testNewClient() {
        Assertions.assertNotNull(new IuguConfiguration("").getNewClientNotAuth());
    }
}