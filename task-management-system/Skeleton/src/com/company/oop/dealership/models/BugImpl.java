package com.company.oop.dealership.models;

import com.company.oop.dealership.models.CommentImpl;
import com.company.oop.dealership.models.enums.Priority;
import com.company.oop.dealership.models.enums.Severity;
import com.company.oop.dealership.models.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class BugImpl extends TaskImpl {

    private static List<String> steps;
    private static Priority priority;
    private static Severity severity;
    private static Status status;
    private static CommentImpl comments;
    private static List<String> history;
    private static MemberImpl assignee;


    public BugImpl(int id, String title, String description, List<String> steps, Priority priority
            , Severity severity, Status status, CommentImpl comments, List<String> history, MemberImpl assignee) {
        super(id, title, description);
        setSteps(steps);
        setPriority(priority);
        setSeverity(severity);
        setComments(comments);
        setHistory(history);
        setAssignee(assignee);
        setStatus(status);
    }



    private void setPriority(Priority priority) {
        if (priority != Priority.HIGH && priority != Priority.MEDIUM && priority != Priority.LOW) {
            throw new IllegalArgumentException("Priority should be High, Medium or Low");
        }
        this.priority = priority;
    }
    private void setSeverity(Severity severity) {
        if (severity != Severity.Critical && severity != Severity.Major && severity != Severity.Minor) {
            throw new IllegalArgumentException("Severity should be Critical, Major, Minor");
        }
        this.severity = severity;
    }
    private void setStatus(Status status) {
        if (status != Status.Active && status != Status.New && status != Status.Unscheduled && status != Status.Scheduled && status != Status.Done) {
            throw new IllegalArgumentException("Status should be Active, New, Unscheduled, Scheduled or Done");
        }
        this.status = status;
    }
    private static void setSteps(List<String> steps) {
        BugImpl.steps = steps;
    }

    private static void setComments(CommentImpl comments) {
        CommentImpl.comments = comments;
    }

    private static void setHistory(List<String> history) {
        BugImpl.history = history;
    }

    public static void setAssignee(MemberImpl assignee) {
        BugImpl.assignee = assignee;
    }



    public static List<String> getSteps() {
        return steps;
    }

    public static CommentImpl getComments() {
        return comments;
    }

    public static List<String> getHistory() {
        return history;
    }

    public static MemberImpl getAssignee() {
        return assignee;
    }

    public static Priority getPriority() {
        return priority;
    }

    public static Severity getSeverity() {
        return severity;
    }

    public static Status getStatus() {
        return status;
    }
}
