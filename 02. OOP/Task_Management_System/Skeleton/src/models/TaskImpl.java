package models;

import java.util.ArrayList;
import java.util.List;

import helpers.ValidationHelpers;
import models.enums.Tasks;
import models.interfaces.Comments;
import models.interfaces.Members;


public class TaskImpl implements models.interfaces.Tasks {

    private static final int MIN_TITLE_SYMBOLS = 10;
    private static final int MAX_TITLE_SYMBOLS = 50;
    private static final String NOT_IN_RANGE_TITLE = "Title is a string between 10 and 50 symbols.";
    private static final int MIN_DESCR_SYMBOLS = 10;
    private static final int MAX_DESCR_SYMBOLS = 500;
    private static final String NOT_IN_RANGE_DESCR = "Description is a string between 10 and 500 symbols.";
    private static final String INVALID_TASK_TYPE = "Task type must be bug, feedback or story";
    private int id;
    private String taskTitle;
    private String description;
    private List<Comments> comments;
    private List<String> history;

    private Tasks taskType;
    private Members assignedMember;



    public TaskImpl(int id, String taskTitle, String description, List<Comments> comments,
                    List<String> history) {
        this.id = id;
        setTaskTitle(taskTitle);
        setDescription(description);
        this.comments = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    @Override
    public void setAssignedMember(Members member) {
        if (member != null) {
            this.assignedMember = member;
        } else {
            this.assignedMember = null;
        }
    }

    public Members getAssignedMember() {
        return assignedMember;
    }
    public int getId() {
        return id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getDescription() {
        return description;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    public Tasks getTaskType() {
        return taskType;
    }

    @Override
    public List<models.interfaces.Tasks> getTasks() {
        return null;
    }

    public void setTaskTitle(String taskTitle) {
        ValidationHelpers.validateStringLength(taskTitle, MIN_TITLE_SYMBOLS, MAX_TITLE_SYMBOLS, NOT_IN_RANGE_TITLE);
        this.taskTitle = taskTitle;
    }

    public void setDescription(String description) {
        ValidationHelpers.validateStringLength(description, MIN_DESCR_SYMBOLS, MAX_DESCR_SYMBOLS, NOT_IN_RANGE_DESCR);
        this.description = description;
    }

    public void setTaskType(Tasks taskType) {
        if (taskType == Tasks.BUG) {
            this.taskType = Tasks.BUG;
        }
        if (taskType == Tasks.STORY) {
            this.taskType = Tasks.STORY;
        }
        if (taskType == Tasks.FEEDBACK) {
            this.taskType = Tasks.FEEDBACK;
        } else {
            throw new IllegalArgumentException(INVALID_TASK_TYPE);
        }
    }
}
