package com.iugu;

import com.iugu.components.rsa.FilePrivateKeyProvider;
import lombok.SneakyThrows;

import java.nio.file.Paths;

public final class Mocks {
    @SneakyThrows
    public static IuguConfiguration mockConfiguration() {
        return new IuguConfiguration(
                TestConstants.IUGU_RSA_TOKEN_TEST,
                new FilePrivateKeyProvider(Paths.get(TestConstants.PRIV_KEY_PATH_TEST))
        );
    }

    @SneakyThrows
    public static IuguConfiguration mockProdConfiguration() {
        return new IuguConfiguration(
                TestConstants.IUGU_RSA_TOKEN_PROD,
                new FilePrivateKeyProvider(Paths.get(TestConstants.PRIV_KEY_PATH_PROD))
        );
    }
}
