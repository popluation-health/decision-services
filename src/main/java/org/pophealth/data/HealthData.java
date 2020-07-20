package org.pophealth.data;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class HealthData {

    private Integer steps;
    private Integer activeMinutes;
    private List<String> rewards = new ArrayList<>();

    public void addRewardName(String name) {
        rewards.add(name);
        System.out.println("Added reward "+name);
    }

}
