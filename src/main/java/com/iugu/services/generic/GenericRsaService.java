package com.iugu.services.generic;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.model.generic.SignedBody;
import com.iugu.model.signature.ValidateSignatureResponse;
import com.iugu.services.signature.ValidateSignatureService;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class GenericRsaService extends GenericService {

    private ValidateSignatureService validateSignatureService;

    public GenericRsaService(IuguConfiguration iugu) {
        super(iugu);
    }

    public GenericRsaService(IuguConfiguration iugu, ValidateSignatureService validateSignatureService) {
        super(iugu);
        this.validateSignatureService = validateSignatureService;
    }

    @SuppressWarnings("all")
    protected <T> T requestWithSignature(String method, String endpoint, Object anyObject, Class<T> responseClass) throws IuguException {
        if (Objects.nonNull(getValidateSignatureService())) {
            ValidateSignatureResponse response = getValidateSignatureService().validateSignature(anyObject);
        }
        try (Client client = getIugu().getNewClient()) {
            SignedBody body = getIugu().signBody(anyObject, method, IuguConfiguration.baseUrl(endpoint));
            Response response = client
                    .target(IuguConfiguration.url(endpoint))
                    .request()
                    .header("Request-Time", body.signedAtAsString())
                    .header("Signature", "signature=" + body.getSignedMessage())
                    .post(Entity.entity(body.getBody(), MediaType.APPLICATION_JSON));

            return readResponse(response, responseClass, "Error validating signature!");
        }
    }

}
