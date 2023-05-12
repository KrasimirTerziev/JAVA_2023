package models.interfaces;

import models.enums.Priority;
import models.enums.Severity;
import models.enums.Status;

public interface Bugs {
    Priority getPriority();

    String GetBugTitle();
    Severity getSeverity();
    Status getStatus();

    String getAssignee();


}
