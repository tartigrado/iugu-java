package com.iugu.services.signature;

import com.iugu.model.signature.ValidateSignatureResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("")
public interface ValidateSignatureServiceProxy extends ValidateSignatureService {

    @Override
    @Path("/signature/validate")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ValidateSignatureResponse validateSignature(
            @HeaderParam("Request-Time") String requestTime,
            @HeaderParam("Signature") String signature,
            String body);

}
