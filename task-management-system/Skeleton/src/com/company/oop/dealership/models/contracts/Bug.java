package com.company.oop.dealership.models.contracts;

import com.company.oop.dealership.models.enums.Priority;
import com.company.oop.dealership.models.enums.Severity;
import com.company.oop.dealership.models.enums.Status;

import java.util.List;

public interface Bug extends Tasks{

    List<String> getSteps();
    List<String> getComments();
    List<String> getHistory();
    String getAssignee();
    Priority getPriority();
    Severity getSeverity();
    Status getStatus();
}
