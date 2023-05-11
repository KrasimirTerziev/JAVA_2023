package models.interfaces;

import java.util.List;

public interface Tasks {
    String getTaskTitle();
    List<Comments> getComments();

    List<String> getHistory();

    models.enums.Tasks getTaskType();


    void setAssignedMember(Members member);
    Members getAssignedMember();
    List<Tasks> getTasks();
}
