package com.iugu.services.signature;

import com.iugu.model.signature.ValidateSignatureResponse;

public interface ValidateSignatureService {

    ValidateSignatureResponse validateSignature(String requestTime, String signature, String body);

    ValidateSignatureResponse validateSignature(Object any);

}
