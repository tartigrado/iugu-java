package com.iugu.services.token;

import com.iugu.model.token.PaymentTokenCreate;
import com.iugu.model.token.response.PaymentTokenResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("")
public interface PaymentTokenServiceProxy extends PaymentTokenService {
    @Override
    @POST
    @Path("/payment_token")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    PaymentTokenResponse createToken(PaymentTokenCreate paymentToken);
}
