package org.pophealth.model;

import lombok.Data;

@Data
public class Alert {

    private String alertName;
    private String alertType;
    private boolean open;
    private String severity;

}
