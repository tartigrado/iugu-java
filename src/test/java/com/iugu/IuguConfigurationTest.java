package com.iugu;

import org.junit.Assert;
import org.junit.Test;

public class IuguConfigurationTest {

    @Test
    public void testGetUrl() {
        Assert.assertEquals("https://api.iugu.com/v1/transfers", IuguConfiguration.url("/transfers"));
    }

    @Test
    public void testGetBaseUrl() {
        Assert.assertEquals("/v1/transfers", IuguConfiguration.baseUrl("/transfers"));
    }

    @Test
    public void testNewClient() {
        Assert.assertNotNull(new IuguConfiguration("").getNewClientNotAuth());
    }
}