package models;

import helpers.ValidationHelpers;
import models.interfaces.Boards;

import java.util.List;

public class BoardImpl implements Boards {

    private static final int BOARDNAME_MIN_LEN =5 ;
    private static final int BOARDNAME_MAX_LEN =10 ;
    private static final String MESSAGE_BOARDNAME_OUT_OF_RANGE_LEN = "Member name length cannot be less " +
            "than 5 or more than 10 symbols long.";
    private String boardName;
    private List<TaskImpl> tasks;
    private List<String> activityhistory;

    public BoardImpl(String boradName, List<TaskImpl> tasks, List<String> activityhistory) {
        this.boardName = boradName;
        this.tasks = tasks;
        this.activityhistory = activityhistory;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoradName(String boradName) {
        ValidationHelpers.validateStringLength(boradName, BOARDNAME_MIN_LEN, BOARDNAME_MAX_LEN, MESSAGE_BOARDNAME_OUT_OF_RANGE_LEN);
        this.boardName = boradName;
    }

    public List<TaskImpl> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskImpl> tasks) {
        this.tasks = tasks;
    }

    public List<String> getActivityhistory() {
        return activityhistory;
    }

    public void setActivityhistory(List<String> activityhistory) {
        this.activityhistory = activityhistory;
    }

    public void addTask(TaskImpl task) {
        tasks.add(task);
    }

    public void removeTask(TaskImpl task) {
        tasks.remove(task);
    }

    public void addActivity(String activity) {
        activityhistory.add(activity);
    }

    public void removeActivity(String activity) {
        activityhistory.remove(activity);
    }

}
