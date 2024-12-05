package com.iugu.services.signature;

import com.iugu.Mocks;
import com.iugu.TestConstants;
import com.iugu.model.signature.ValidateSignatureResponse;
import lombok.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateSignatureServiceImplTest {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static final class TestSign {
        private String token;
        private String message;
    }

    ValidateSignatureService validate = new ValidateSignatureServiceImpl(Mocks.mockProdConfiguration());

    @Test
    @DisplayName("ValidateSignatureService: should validate signature")
    void testValidateSignature() {
        ValidateSignatureResponse validateSignature = validate.validateSignature(TestSign
                .builder()
                .token(TestConstants.IUGU_RSA_TOKEN_PROD)
                .message("Teste")
                .build());
        Assertions.assertEquals("Signature check successful", validateSignature.getMessage());
    }

}