package org.pophealth.rewards;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.kie.api.runtime.KieSession;
import org.kie.kogito.rules.KieRuntimeBuilder;
import org.pophealth.model.HealthData;

@ApplicationScoped
public class HealthDataService {

    @Inject
    KieRuntimeBuilder builder;

    public List<HealthData> processRewards(List<HealthData> data) {

        KieSession session = builder.newKieSession();
        data.forEach(val -> session.insert(val));
        session.fireAllRules();

        return data;
    }
}
