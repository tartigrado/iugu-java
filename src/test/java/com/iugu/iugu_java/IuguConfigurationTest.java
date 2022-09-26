package com.iugu.iugu_java;

import com.iugu.IuguConfiguration;
import junit.framework.TestCase;

public class IuguConfigurationTest extends TestCase {

    public void testNewClient() {
        assertNotNull(new IuguConfiguration("").getNewClientNotAuth());
    }
}
