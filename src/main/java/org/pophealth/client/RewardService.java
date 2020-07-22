package org.pophealth.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.pophealth.model.Reward;

@RegisterRestClient
public interface RewardService {

    @POST
    @Path("/reward")
    @Consumes(MediaType.APPLICATION_JSON)
    void issueReward(Reward reward);
}
