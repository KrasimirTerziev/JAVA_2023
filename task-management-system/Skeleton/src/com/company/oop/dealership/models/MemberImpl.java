package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Members;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class MemberImpl implements Members {

private static String name;
private static List<String>tasks;
private static List<String>activityhistory;

    private static MemberImpl assignee;

    private static List<MemberImpl> members = new ArrayList<>();

    public MemberImpl(String name, List<String>tasks, List<String>activityhistory) {
        setName(name);
        setTasks(tasks);
        setActivityhistory(activityhistory);
        members.add(this);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        ValidationHelpers.validateStringLength(name, 5, 15, "Name must be between 5 and 15 symbols");
        // Check if the name is already used by another team
        for (MemberImpl member : members) {
            if (member.getName().equals(name)) {
                throw new IllegalArgumentException("Name already exists in the application");
            }
        }

        this.name = name;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public static void setTasks(List<String> tasks) {
        MemberImpl.tasks = tasks;
    }

    public List<String> getActivityHistory() {
        return activityhistory;
    }

    public static void setActivityhistory(List<String> activityhistory) {
        MemberImpl.activityhistory = activityhistory;
    }
}

