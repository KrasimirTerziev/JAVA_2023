package models.interfaces;

import models.BoardImpl;
import models.TaskImpl;

import java.util.List;

public interface Boards {
    String getBoardName();

    List<TaskImpl> getTasks();

    List<String> getActivityhistory();

}
