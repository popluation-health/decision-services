package org.pophealth.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class HealthData {

    private Integer steps;
    private Integer activeMinutes;
    private Integer age;
    private Double sleepRpms;
    private Double sleepHours;
    private Double sleepAvgRpms;
    private Double heartRateBpm;
    private LocalDate measurementDate;

    private List<Reward> rewards = new ArrayList<>();
    private List<Alert> alerts = new ArrayList<>();

    public void addReward(Reward reward) {
        rewards.add(reward);
    }

    public void addAlert(Alert alert){
        alerts.add(alert);
    }
}
