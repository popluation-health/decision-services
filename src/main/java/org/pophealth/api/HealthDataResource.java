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
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.pophealth.client.AlertService;
import org.pophealth.client.RewardService;
import org.pophealth.model.HealthData;
import org.pophealth.rewards.HealthDataService;

@Path("/healthRules")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HealthDataResource {

    private final Logger log = LoggerFactory.getLogger(HealthDataResource.class);

    @Inject
    HealthDataService healthService;

    @Inject
    @RestClient
    RewardService rewardService;

    @Inject
    @RestClient
    AlertService alertService;

    @POST
    public List<HealthData> processHealthData(List<HealthData> data) {

        healthService.processRules(data);

        data.stream()
                .filter(val -> !val.getRewards().isEmpty())
                .forEach(result -> log.info("Rewards "+ result.getRewards()));

        try {
            for (HealthData healthInstance : data) {
                if (healthInstance.getRewards() != null) {
                    rewardService.issueReward(healthInstance.getRewards());

                }
            }
        }catch(Exception e){
            log.error("Failed to psot rewards ",e);
        }
        data.stream()
                .filter(val -> !val.getAlerts().isEmpty())
                .forEach(result -> log.info("Alerts "+ result.getAlerts()));

        for(HealthData healthInstance : data) {
            if(healthInstance.getAlerts() !=null) {
                healthInstance.getAlerts().forEach(alert -> alertService.issueAlert(alert));
            }
        }

        return data;

    }

}
