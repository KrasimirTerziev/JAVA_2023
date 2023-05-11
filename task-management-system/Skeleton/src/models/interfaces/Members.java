package models.interfaces;

import models.TaskImpl;

import java.util.ArrayList;

public interface Members {

    String getMemberName();

    ArrayList<Tasks> getTasks();

    ArrayList<String> getActivityHistory();
}
