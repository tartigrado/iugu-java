package com.iugu.services.withdraw;

import com.iugu.model.withdraw.response.WithdrawResponse;
import com.iugu.model.withdraw.WithdrawFilter;
import com.iugu.model.withdraw.response.WithdrawsResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("")
public interface WithdrawServiceProxy extends WithdrawService {

    @Override
    @GET
    @Path("/withdraw_requests")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    WithdrawsResponse listWithdraws(@BeanParam WithdrawFilter withdrawFilter);

    @Override
    @GET
    @Path("/withdraw_requests/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    WithdrawResponse detailWithdraw(@PathParam("id") String id);


    @Override
    @POST
    @Path("/accounts/{accountId}/request_withdraw")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    WithdrawResponse withdrawRequest(
            @PathParam("accountId") String accountId,
            @HeaderParam("Request-Time") String requestTime,
            @HeaderParam("Signature") String signature,
            String body
    );
}
