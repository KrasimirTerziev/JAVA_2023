package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;

import com.company.oop.dealership.models.contracts.Commentable;
import com.company.oop.dealership.models.contracts.Identifable;
import com.company.oop.dealership.models.contracts.Tasks;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class TaskImpl implements Tasks, Identifable{

    private static int id;

    private static String title;

    private static String description;

    public TaskImpl(int id, String title, String description) {
        setId(id);
        setTitle(title);
        setDescription(description);

    }

    @Override
    public int getId() {
        return id;
    }

    public static void setId(int id) {
        if(id <= 0) {
            throw new IllegalArgumentException("Id must be a positive number");
        }else {
            TaskImpl.id = id;
        }
    }

    @Override
    public String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        ValidationHelpers.validateStringLength(title, 10, 50, "Title must be between 10 and 50 symbols");
        TaskImpl.title = title;
    }

    public String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        ValidationHelpers.validateStringLength(description, 10, 500, "Description must be between 10 and 50 symbols");
        TaskImpl.description = description;
    }


}
