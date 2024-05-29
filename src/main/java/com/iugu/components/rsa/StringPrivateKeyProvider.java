package com.iugu.components.rsa;

import com.iugu.interfaces.PrivateKeyProvider;
import com.iugu.utils.KeyUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.security.PrivateKey;

@SuperBuilder
@Getter
@RequiredArgsConstructor
public class StringPrivateKeyProvider implements PrivateKeyProvider {

    private final PrivateKey privateKey;

    public StringPrivateKeyProvider(String privateKey) {
        this(KeyUtils.privateKey(privateKey));
    }
}
