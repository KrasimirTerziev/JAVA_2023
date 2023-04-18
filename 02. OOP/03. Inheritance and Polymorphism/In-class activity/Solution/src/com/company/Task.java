package com.company;

import java.time.LocalDate;

public class Task extends BoardItem {
    private String assignee;

    public Task(String title, String assignee, LocalDate dueDate) {
        super(title, dueDate, Status.TODO);
        this.assignee = assignee;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        if (assignee.length() < 5 || assignee.length() > 30) {
            throw new IllegalArgumentException();
        }

        logEvent(String.format("Assignee changed from %s to %s", getAssignee(), assignee));

        this.assignee = assignee;
    }

    @Override
    public Status getStatus() {
        return super.getStatus();
    }

    @Override
    public void revertStatus() {
        String status = String.valueOf(getStatus());
        if (!status.equals("Verified")) {
            status = "Verified";
        }
    }

    @Override
    public void advanceStatus() {
        String status = String.valueOf(getStatus());
        if (!status.equals("Open")) {
            status = "Open";
        }
    }
}
