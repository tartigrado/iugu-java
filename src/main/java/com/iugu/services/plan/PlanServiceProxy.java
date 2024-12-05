package com.iugu.services.plan;

import com.iugu.model.plan.PlanCreate;
import com.iugu.model.plan.PlanFilter;
import com.iugu.model.plan.PlanUpdate;
import com.iugu.model.plan.response.PlanResponse;
import com.iugu.model.plan.response.PlansResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("")
public interface PlanServiceProxy extends PlanService {

    @Override
    @GET
    @Path("/plans")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    PlansResponse listPlans(@BeanParam PlanFilter filter);

    @Override
    @GET
    @Path("/plans/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    PlanResponse getPlan(@PathParam("id") String id);

    @Override
    @GET
    @Path("/plans/identifier/{identifier}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    PlanResponse getPlanByIdentifier(@PathParam("identifier") String identifier);

    @Override
    @POST
    @Path("/plans")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    PlanResponse createPlan(PlanCreate plan);

    @Override
    @PUT
    @Path("/plans/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    PlanResponse updatePlan(@PathParam("id") String id, PlanUpdate plan);

    @Override
    @DELETE
    @Path("/plans/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    PlanResponse deletePlan(@PathParam("id") String id);

}
