package com.iugu.services.dunning;


import com.iugu.model.dunning.ChangeDunningStep;
import com.iugu.model.dunning.DunningStep;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("")
public interface DunningStepsServiceProxy extends DunningStepsService {


    @Override
    @GET
    @Path("/dunning_steps")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    List<DunningStep> getDunningSteps();

    @Override
    @PUT
    @Path("/dunning_steps")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    List<DunningStep> changeDunningSteps(ChangeDunningStep change);
}
