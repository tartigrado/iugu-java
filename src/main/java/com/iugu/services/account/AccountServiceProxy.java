package com.iugu.services.account;

import com.iugu.model.account.response.AccountCreateResponse;
import com.iugu.model.account.response.AccountResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("")
public interface AccountServiceProxy extends AccountService {

    @Override
    @POST
    @Path("/accounts/configuration")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    AccountResponse configureAccount(
            @HeaderParam("Request-Time") String requestTime,
            @HeaderParam("Signature") String signature,
            String body
    );

    @Override
    @POST
    @Path("/marketplace/create_account")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    AccountCreateResponse createAccount(
            @HeaderParam("Request-Time") String requestTime,
            @HeaderParam("Signature") String signature,
            String body
    );

    @Override
    @GET
    @Path("/accounts/{id}")
    AccountResponse detailAccount(@PathParam("id") String id);
}
