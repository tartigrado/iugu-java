package com.iugu.services;

import com.iugu.IuguConfiguration;
import com.iugu.Mocks;
import com.iugu.TestConstants;
import com.iugu.components.rsa.FilePrivateKeyProvider;
import com.iugu.model.signature.ValidateSignatureResponse;
import lombok.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class ValidateSignatureServiceTest {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static final class TestSign {
        private String token;
        private String message;
    }

    @Test
    public void testValidateSignature() throws Exception {
        ValidateSignatureService validate = new ValidateSignatureService(Mocks.mockConfiguration());

        ValidateSignatureResponse validateSignature = validate.validateSignature(TestSign
                .builder()
                .token(TestConstants.IUGU_TOKEN_RSA)
                .message("Teste")
                .build());

        Assert.assertEquals("Signature check successful", validateSignature.getMessage());
    }
}