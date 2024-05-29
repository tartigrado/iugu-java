package com.iugu;

import com.iugu.components.rsa.FilePrivateKeyProvider;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

public class Mocks {
    @SneakyThrows
    public static IuguConfiguration mockConfiguration() {
        return new IuguConfiguration(
                TestConstants.IUGU_TOKEN_RSA,
                new FilePrivateKeyProvider(FileUtils.getFile(TestConstants.PRIV_KEY_PATH))
        );
    }
}
