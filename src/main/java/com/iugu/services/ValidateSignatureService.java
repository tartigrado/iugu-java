package com.iugu.services;

import com.iugu.IuguConfiguration;
import jakarta.ws.rs.client.Client;
import com.iugu.exceptions.IuguException;
import com.iugu.model.generic.SignedBody;
import com.iugu.model.signature.ValidateSignatureResponse;
import com.iugu.services.generic.GenericRsaService;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public final class ValidateSignatureService extends GenericRsaService {
    private final static String VALIDATE_URL = "/signature/validate";

    public ValidateSignatureService(IuguConfiguration iugu) {
        super(iugu);
    }

    public ValidateSignatureResponse validateSignature(Object anyObject) throws IuguException {
        try (Client client = getIugu().getNewClient()) {
            SignedBody body = getIugu().signBody(anyObject, "POST", IuguConfiguration.baseUrl(VALIDATE_URL));
            Response response = client
                    .target(IuguConfiguration.url(VALIDATE_URL))
                    .request()
                    .header("Request-Time", body.signedAtAsString())
                    .header("Signature", "signature=" + body.getSignedMessage())
                    .post(Entity.entity(body.getBody(), MediaType.APPLICATION_JSON));

            return readResponse(response, ValidateSignatureResponse.class, "Error validating signature!");
        }

    }
}
