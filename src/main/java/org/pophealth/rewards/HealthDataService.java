package org.pophealth.rewards;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.kie.kogito.rules.RuleUnit;
import org.pophealth.data.HealthData;

@ApplicationScoped
public class HealthDataService {

    @Inject
    RuleUnit<RewardsHealthDataUnit> rewardsUnit;

    public HealthData processRewards(HealthData data) {
        RewardsHealthDataUnit unit = new RewardsHealthDataUnit();
        unit.getHealthData().add(data);
        rewardsUnit.createInstance(unit).fire();

        return data;
    }

}
