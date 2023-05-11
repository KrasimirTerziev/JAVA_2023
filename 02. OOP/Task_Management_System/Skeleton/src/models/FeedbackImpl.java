package models;

import models.enums.Status;
import models.enums.Tasks;
import models.interfaces.Comments;
import models.interfaces.FeedBack;

import java.util.List;

public class FeedbackImpl extends TaskImpl implements FeedBack {
    private int rating;

    private Status feedbackstatus;


    public FeedbackImpl(int id, String taskTitle, String description, List<Comments> comments, List<String> history, int rating, Status feedbackstatus) {
        super(id, taskTitle, description, comments, history);
        setRating(rating);
        setFeedbackstatus(feedbackstatus);

    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Status getFeedbackstatus() {
        return feedbackstatus;
    }

    public void setFeedbackstatus(Status feedbackstatus) {
        this.feedbackstatus = feedbackstatus;
    }
}
