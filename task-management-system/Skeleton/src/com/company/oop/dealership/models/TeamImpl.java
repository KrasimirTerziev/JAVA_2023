package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Team;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class TeamImpl implements Team {

    private static List<TeamImpl> teams = new ArrayList<>();
    private static String name;
    private static List<String> members;

    private static List<String> boards;

    private static MemberImpl assignee;



    public TeamImpl(String name, List<String> members, List<String> boards) {
        setName(name);
        setMembers(members);
        setBoards(boards);
        teams.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ValidationHelpers.validateStringLength(name, 5, 15, "Name must be between 5 and 15 symbols");

        // Check if the name is already used by another team
        for (TeamImpl team : teams) {
            if (team.getName().equals(name)) {
                throw new IllegalArgumentException("Name already exists in the application");
            }
        }

        this.name = name;
    }

    public  List<String> getMembers() {
        //To-do GetMembers function should get the members array list of MemberImpl with members,tasks and their activityhistory
        return members;
    }

    public static void setMembers(List<String> members) {
        TeamImpl.members = members;
    }

    public  List<String> getBoards() {
        //To-Do GetBoard funciton should get the boards array list of BoardsImpl with members,tasks and their activityhistory
        return boards;
    }

    public static void setBoards(List<String> boards) {
        TeamImpl.boards = boards;
    }
}
