package models;

import models.enums.*;
import models.interfaces.Bugs;
import models.interfaces.Comments;
import models.interfaces.Members;

import java.util.List;

public class BugImpl extends TaskImpl implements Bugs {
    /**
     * constructor
     * */
    private Priority bugPriority;

    private Severity severity;

    private Status bugStatus;

    private Members bugAssignee;


    public BugImpl(int id, String taskTitle, String description, List<Comments> comments, List<String> history, Priority bugPriority,
                   Severity severity, Status bugStatus, Members bugAssignee) {
        super(id, taskTitle, description, comments, history);
        setPriority(bugPriority);
        setSeverity(severity);
        setStatus(bugStatus);
        setAssignee(bugAssignee);
    }

    public Priority getPriority() {
        return bugPriority;
    }

    public void setPriority(Priority bugPriority) {
        this.bugPriority = bugPriority;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Status getStatus() {
        return bugStatus;
    }

    public void setStatus(Status bugStatus) {
        this.bugStatus = bugStatus;
    }

    public Members getAssignee() {
        return bugAssignee;
    }

    public void setAssignee(Members bugAssignee) {
        this.bugAssignee = bugAssignee;
    }
}
