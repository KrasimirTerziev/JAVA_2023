package models.interfaces;

import models.enums.Priority;
import models.enums.Severity;
import models.enums.Status;

public interface Bugs {
    Priority getPriority();
    Severity getSeverity();
    Status getStatus();

    Members getAssignee();


}
