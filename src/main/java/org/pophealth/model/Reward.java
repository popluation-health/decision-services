package org.pophealth.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Reward {

    private String rewardName;
    private Double value;
    private boolean fulfilled;
    private String category;
    private LocalDate measurementDate;

}
