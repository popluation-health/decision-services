# Serverless Decision Services for Population Health
Serverless decision services using Quarkus and Kogito. 

See (https://popluation-health.github.io/pop-health-docs/) for getting started and documentation.

Run locally with: 
`mvn clean compile quarkus:dev`


Note: If you want to build a native image from thise you need to remove this from the pom:

```
<configuration>
  <uberJar>true</uberJar>
</configuration>
```

Follow this issue for more details:
https://issues.redhat.com/browse/KOGITO-1683
                
            
