package org.pophealth.rewards;

import javax.enterprise.context.ApplicationScoped;
import org.pophealth.data.HealthData;

@ApplicationScoped
public class HealthDataService {

//    @Inject
//    RuleUnit<RewardsHealthDataUnit> rewardsUnit;


    public HealthData processRewards(HealthData data) {
//        RewardsHealthDataUnit unit = new RewardsHealthDataUnit();
//        unit.getHealthData().add(data);
//        rewardsUnit.createInstance(unit).fire();

//        KieSession session = builder.newKieSession();
//        session.insert(data);
//        session.fireAllRules();

        return data;
    }

}
