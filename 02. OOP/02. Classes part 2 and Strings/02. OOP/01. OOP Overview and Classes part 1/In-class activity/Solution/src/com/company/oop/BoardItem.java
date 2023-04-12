package com.company.oop;

import java.time.LocalDate;

public class BoardItem {
    String title;
    LocalDate dueDate;
    Status status;

    BoardItem(String title, LocalDate dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        status = Status.OPEN;
    }

    void advanceStatus() {
        switch (status) {
            case OPEN:
                status = Status.TODO;
                break;
            case TODO:
                status = Status.IN_PROGRESS;
                break;
            case IN_PROGRESS:
                status = Status.DONE;
                break;
            case DONE:
                status = Status.VERIFIED;
                break;
        }
    }

    void revertStatus() {
        switch (status) {
            case VERIFIED:
                status = Status.DONE;
                break;
            case DONE:
                status = Status.IN_PROGRESS;
                break;
            case IN_PROGRESS:
                status = Status.TODO;
                break;
            case TODO:
                status = Status.OPEN;
                break;
        }
    }

    String viewInfo() {
        return String.format("'%s', [%s | %s]", title, status, dueDate);
    }
}
