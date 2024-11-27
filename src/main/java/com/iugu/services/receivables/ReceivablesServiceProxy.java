package com.iugu.services.receivables;

import com.iugu.model.receivables.AnticipationSimulation;
import com.iugu.model.receivables.ReceivablesFilter;
import com.iugu.model.receivables.TransactionAdvance;
import com.iugu.model.receivables.response.AnticipationSimulationResponse;
import com.iugu.model.receivables.response.CheckAdvanceResponse;
import com.iugu.model.receivables.response.ReceivablesResponse;
import com.iugu.model.receivables.response.TransactionAdvanceResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("")
public interface ReceivablesServiceProxy extends ReceivablesService {

    @Override
    @GET
    @Path("/financial_transaction_requests")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    ReceivablesResponse listReceivables(@BeanParam ReceivablesFilter filter);

    @Override
    @POST
    @Path("/advancement_request/simulation")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    void createAnticipationSimulation(AnticipationSimulation simulation);

    @Override
    @GET
    @Path("/advancement_request/simulation")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    AnticipationSimulationResponse checkAnticipationSimulation();

    @Override
    @POST
    @Path("/financial_transaction_requests/advance")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    TransactionAdvanceResponse transactionAdvance(TransactionAdvance advance);

    @Override
    @POST
    @Path("/advancement_request")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    void approveAdvance();

    @Override
    @GET
    @Path("/advancement_request")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    CheckAdvanceResponse checkAdvanceResponse();

}
