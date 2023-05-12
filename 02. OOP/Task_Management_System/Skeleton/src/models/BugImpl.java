package models;

import models.enums.*;
import models.interfaces.Bugs;
import models.interfaces.Comments;
import models.interfaces.Members;

import java.util.List;

public class BugImpl extends TaskImpl implements Bugs {
    /**
     * constructor
     */
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
        setAssignedMember(bugAssignee);
        // setTaskType(Tasks.BUG);
    }

    public String GetBugTitle() {
        return getTaskTitle();
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

    public String getAssignee() {
        return bugAssignee.getMemberName();
    }

    @Override
    public void setAssignedMember(Members member) {
        if (member != null) {
            this.bugAssignee = member;
        } else {
            this.bugAssignee = null;
        }
    }

    public String getAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                "---- Task ---- \n");
        stringBuilder.append("Task type: BUG" + "\n");
        stringBuilder.append("Task Id: " + getId() + "\n");
        stringBuilder.append("Task name: " + getTaskTitle() + "\n");
        stringBuilder.append("Description: " + getDescription() + "\n");
        if (getComments().isEmpty()) stringBuilder.append("No comments\n");
        else {
           for( Comments comments:getComments())
            {
                stringBuilder.append("*** Comment for this bug *** \n");
                stringBuilder.append("Comment author: "+comments.getAuthor()+ "\n");
                stringBuilder.append("Comment content: "+comments.getContent()+ "\n");
            }
        }
        stringBuilder.append("Priority : " + getPriority() + "\n");
        stringBuilder.append("Severity : " + getSeverity() + "\n");
        stringBuilder.append("Status : " + getStatus() + "\n");
        stringBuilder.append("Asignee : " + getAssignee() + "\n");
        return stringBuilder.toString();
    }

    public String toString() {
        return getAsString();
    }

}
