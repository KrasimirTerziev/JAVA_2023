package com.company;

import java.time.LocalDate;

class Issue extends BoardItem {

    private String description;

    public Issue(String title, String description, LocalDate dueDate) {
        super(title, dueDate);
        this.description = description;
    }

    public void setDescription(String description) {
        if (description.isEmpty()) {
            throw new IllegalArgumentException("Can not be empty!");
        } else {
            this.description = description;
        }
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void setINITIAL_STATUS() {
        this.INITIAL_STATUS = Status.OPEN;
    }
}
