package org.pophealth.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.pophealth.data.HealthData;
import org.pophealth.rewards.HealthDataService;

@Path("/healthRules")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HealthDataResource {

    @Inject
    HealthDataService healthService;

    @POST
    public HealthData processHealthData(HealthData data) {

//        healthService.processAlerts(data);
        healthService.processRewards(data);

        return data;

    }

}
