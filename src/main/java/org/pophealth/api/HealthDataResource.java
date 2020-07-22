package org.pophealth.api;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.pophealth.model.HealthData;
import org.pophealth.rewards.HealthDataService;

@Path("/healthRules")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HealthDataResource {

    private final Logger log = LoggerFactory.getLogger(HealthDataResource.class);

    @Inject
    HealthDataService healthService;

    @POST
    public List<HealthData> processHealthData(List<HealthData> data) {

//        healthService.processAlerts(data);
        healthService.processRewards(data);

        data.stream()
                .filter(val -> !val.getRewards().isEmpty())
                .forEach(result -> log.info("Rewards "+ result.getRewards()));

        data.stream()
                .filter(val -> !val.getAlerts().isEmpty())
                .forEach(result -> log.info("Alerts "+ result.getAlerts()));

        return data;

    }

}
