package com.iugu.services;

import com.iugu.Mocks;
import com.iugu.TestConstants;
import com.iugu.model.signature.ValidateSignatureResponse;
import lombok.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        ValidateSignatureService validate = new ValidateSignatureService(Mocks.mockProdConfiguration());

        ValidateSignatureResponse validateSignature = validate.validateSignature(TestSign
                .builder()
                .token(TestConstants.IUGU_RSA_TOKEN_PROD)
                .message("Teste")
                .build());

        Assertions.assertEquals("Signature check successful", validateSignature.getMessage());
    }
}