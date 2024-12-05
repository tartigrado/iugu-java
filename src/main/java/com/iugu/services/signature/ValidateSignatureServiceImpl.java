package com.iugu.services.signature;

import com.iugu.IuguConfiguration;
import com.iugu.components.HttpClientManager;
import com.iugu.exceptions.IuguExceptionHandler;
import com.iugu.model.generic.SignedBody;
import com.iugu.model.signature.ValidateSignatureResponse;
import jakarta.ws.rs.WebApplicationException;

public final class ValidateSignatureServiceImpl implements ValidateSignatureService {

    private final IuguConfiguration configuration;
    private final ValidateSignatureService proxy;

    public ValidateSignatureServiceImpl(IuguConfiguration configuration) {
        this.configuration = configuration;
        this.proxy = HttpClientManager.proxy(ValidateSignatureServiceProxy.class, configuration.authenticator());
    }

    @Override
    public ValidateSignatureResponse validateSignature(String requestTime, String signature, String body) {
        try {
            return proxy.validateSignature(requestTime, signature, body);
        } catch (WebApplicationException ex) {
            throw IuguExceptionHandler.getException(ex);
        }
    }

    @Override
    public ValidateSignatureResponse validateSignature(Object any) {
        SignedBody body = configuration.signBody(any, "POST", IuguConfiguration.baseUrl("/signature/validate"));
        return validateSignature(body.signedAtAsString(), "signature=" + body.getSignedMessage(), body.getBody());
    }

}
