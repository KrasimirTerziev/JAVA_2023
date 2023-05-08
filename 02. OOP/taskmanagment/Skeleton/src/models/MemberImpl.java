package models;

import java.util.ArrayList;
import java.util.List;

import helpers.ValidationHelpers;
import models.interfaces.Members;
import models.interfaces.Tasks;


public class MemberImpl implements Members {

    private static final int MEMBERNAME_MIN_LEN =5 ;
    private static final int MEMBARNAME_MAX_LEN =15 ;
    private static final String MESSAGE_MEMBERNAME_OUT_OF_RANGE_LEN = "Member name length cannot be less " +
            "than 5 or more than 15 symbols long.";
    private String name;
    private ArrayList<Tasks> tasks;
    private ArrayList<String> activityHistory;

    private List<Members> members;


    public MemberImpl(String name, List<Tasks> tasks, List<String> activityhistory) {
        this.name = name;
        this.tasks = new ArrayList<Tasks>();
        this.activityHistory = new ArrayList<String>();
    }


    public String getMemberName() {
        return name;
    }

    public void setName(String name) {
        ValidationHelpers.validateStringLength(name, MEMBERNAME_MIN_LEN, MEMBARNAME_MAX_LEN,
                MESSAGE_MEMBERNAME_OUT_OF_RANGE_LEN);
        this.name = name;
    }

    public ArrayList<Tasks> getTasks() {
        return tasks;
    }

    public ArrayList<String> getActivityHistory() {
        return activityHistory;
    }

    public void addTask(Tasks task) {
        tasks.add(task);
    }

    public void removeTask(Tasks task) {
        tasks.remove(task);
    }

    public void addActivity(String activity) {
        activityHistory.add(activity);
    }

    public void removeActivity(String activity) {
        activityHistory.remove(activity);
    }
}