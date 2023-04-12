package com.company;

import java.time.LocalDate;

class Task extends BoardItem {
    private String assignee;

    public Task(String title, String assignee, LocalDate dueDate) {
        super(title, dueDate);
        this.assignee = assignee;
    }

    public void setAssignee(String assignee) {
        validateAssignee(assignee);

        logEvent(String.format("Assignee changed from %s to %s", getAssignee(), assignee));

        this.assignee = assignee;
    }

    @Override
    public void setINITIAL_STATUS() {
        this.INITIAL_STATUS = Status.TODO;
    }

    public String getAssignee() {
        return assignee;
    }

    @Override
    public Status getStatus() {
        return super.getStatus();
    }

    @Override
    public void advanceStatus() {
        super.advanceStatus();
    }

    @Override
    public void revertStatus() {
        super.revertStatus();
    }

    private void validateAssignee(String assignee) {
        if (assignee.length() < TITLE_MIN_LENGTH || assignee.length() > TITLE_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(
                    "Please provide a title with length between %d and %d chars",
                    TITLE_MIN_LENGTH, TITLE_MAX_LENGTH));
        }
    }
}
