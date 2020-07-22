package org.pophealth.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Alert {

    private String alertName;
    private String alertType;
    private boolean open;
    private String severity;
    private LocalDate measurementDate;

}
