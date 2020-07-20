package org.pophealth.rewards;

import org.kie.kogito.rules.DataSource;
import org.kie.kogito.rules.DataStore;
import org.kie.kogito.rules.RuleUnitData;
import org.pophealth.data.HealthData;


public class RewardsHealthDataUnit implements RuleUnitData {

    private DataStore<HealthData> healthData = DataSource.createStore();

    public DataStore<HealthData> getHealthData() {
        return healthData;
    }

    public void setHealthData(DataStore<HealthData> healthData) {
        this.healthData = healthData;
    }


}
