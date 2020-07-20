# decision-services

Reproduce rules not loading via manual rule unit execution. The decision table rewards.xls contains very basic rules that should hit
using the curl request below (or for any value of steps) but the RuleUnit injection doesn't hit them.

However, injecting the `KieRuntimeBuilder` and executing manually works.
```
        KieSession session = builder.newKieSession();
        session.insert(data);
        session.fireAllRules();
```

See `HealthDataResource.java` for API
See: `HealthDataService.java` for RuleUnit injection


https://github.com/popluation-health/decision-services/blob/quarkus-repro/src/main/java/org/pophealth/rewards/HealthDataService.java

## Try it out
1. `mvn clean compile quarkus:dev`
2. `curl -X POST "http://localhost:8080/healthRules" -H "accept: application/json" -H "Content-Type: application/json" -d "{\"steps\":18000}"`
