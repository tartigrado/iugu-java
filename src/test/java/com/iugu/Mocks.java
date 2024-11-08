package com.iugu;

import com.iugu.components.rsa.FilePrivateKeyProvider;
import lombok.SneakyThrows;

import java.nio.file.Paths;

public class Mocks {
    @SneakyThrows
    public static IuguConfiguration mockConfiguration() {
        return new IuguConfiguration(
                TestConstants.IUGU_TOKEN_RSA,
                new FilePrivateKeyProvider(Paths.get(TestConstants.PRIV_KEY_PATH))
        );
    }
}
