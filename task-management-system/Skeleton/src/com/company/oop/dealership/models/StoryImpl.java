package com.company.oop.dealership.models;

import com.company.oop.dealership.models.enums.Priority;
import com.company.oop.dealership.models.enums.Size;
import com.company.oop.dealership.models.enums.Status;

import java.util.ArrayList;
import java.util.concurrent.CompletionException;

public class StoryImpl extends TaskImpl {
    private static Priority priority;
    private static Size size;
    private static Status status;
    private CommentImpl comments;

    private static MemberImpl assignee;
    private ArrayList<String> history;

    public StoryImpl(int id, String title, String description, Priority priority,
                     Size size, Status status, MemberImpl assignee, CommentImpl comments, ArrayList<String> history) {
        super(id, title, description);
        setPriority(priority);
        setSize(size);
        setStatus(status);
        this.assignee=assignee;
        this.comments = comments;
        this.history = history;



    }

    public static Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        if (priority == Priority.HIGH || priority == Priority.LOW || priority == Priority.MEDIUM) {
            this.priority = priority;
        } else {
            throw new IllegalArgumentException("Priority must be  one of the following: High, Medium, or Low.");
        }
    }

    public static Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        if (size == Size.LARGE || size == Size.MEDIUM || size == Size.MEDIUM) {
            this.size = size;
        } else {
            throw new IllegalArgumentException("Size must be one of the following: Large, Medium, or Small.");
        }
    }

    public static Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status == Status.NotDone || status == Status.InProgress || status == Status.Done) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Status must be one of the following: Not Done, InProgress, or Done");
        }
    }

    public MemberImpl getAssignee() {
        return assignee;
    }
    public void setAssignee(MemberImpl assignee) {
        StoryImpl.assignee = assignee;
    }

    public CommentImpl getComments() {
        return comments;
    }

    public void setComments(CommentImpl comments) {
        this.comments = comments;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
}
