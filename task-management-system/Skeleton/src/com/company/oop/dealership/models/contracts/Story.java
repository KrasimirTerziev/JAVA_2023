package com.company.oop.dealership.models.contracts;

import com.company.oop.dealership.models.enums.Priority;
import com.company.oop.dealership.models.enums.Size;
import com.company.oop.dealership.models.enums.Status;

import java.util.List;

public interface Story extends Tasks{
    Priority getPriority();
    Size getSize();
    Status getStatus();
    String getAssignee();

    List<Comment> getComments();

    List<String> getHistory();
}
