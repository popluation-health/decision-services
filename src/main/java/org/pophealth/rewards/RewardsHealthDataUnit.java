package org.pophealth.rewards;

import lombok.Data;
import org.kie.kogito.rules.DataSource;
import org.kie.kogito.rules.DataStore;
import org.kie.kogito.rules.RuleUnitData;
import org.pophealth.data.HealthData;

@Data
public class RewardsHealthDataUnit implements RuleUnitData {

    private DataStore<HealthData> healthData = DataSource.createStore();

}
