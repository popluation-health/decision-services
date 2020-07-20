package org.pophealth.rewards;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.kie.api.runtime.KieSession;
import org.kie.kogito.rules.KieRuntimeBuilder;
import org.pophealth.data.HealthData;

@ApplicationScoped
public class HealthDataService {

    @Inject
    KieRuntimeBuilder builder;

    public HealthData processRewards(HealthData data) {

        KieSession session = builder.newKieSession();
        session.insert(data);
        session.fireAllRules();

        return data;
    }
}
