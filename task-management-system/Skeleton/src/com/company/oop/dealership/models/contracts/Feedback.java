package com.company.oop.dealership.models.contracts;
import java.util.List;

public interface Feedback extends Tasks {
    int getRating();

    String getStatus();

    List<Comment> getComments();

    List<String> getHistory();
}
