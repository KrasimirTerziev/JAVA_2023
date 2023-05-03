package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.enums.Status;
import jdk.jshell.Snippet;

import java.util.List;

public class FeedbackImpl extends TaskImpl {
    private int rating;
    private Status status;
    private CommentImpl comments;
    private List<String> history;

    public FeedbackImpl(int id, String title, String description, int rating, Status status,
                        CommentImpl comments, List<String> history) {
        super(id, title, description);
        setRating(rating);
        setStatus(status);
        this.comments = comments;
        this.history = history;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status != Status.New && status != Status.Scheduled && status != Status.Unscheduled && status != Status.Done){
            throw new IllegalArgumentException("Feedback status should be New,Sheduled,Unsheduled or Done");
    } else
    {
        this.status = status;
    }

}

    public CommentImpl getComments() {
        return comments;
    }

    public void setComments(CommentImpl comments) {
        this.comments = comments;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }
}
