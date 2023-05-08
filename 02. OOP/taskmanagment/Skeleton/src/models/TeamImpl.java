package models;

import helpers.ValidationHelpers;
import models.interfaces.Boards;
import models.interfaces.Members;
import models.interfaces.Teams;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class TeamImpl implements Teams {
    private static final String MISSING_TEAM_NAME = "Empty team name is not allowed.";
    private static final int TEAMNAME_MIN_LEN = 5;
    private static final int TEAMNAME_MAX_LEN = 15;
    private static final String TEAMNAME_OUT_OF_RANGE_LEN = "Team name length cannot be less " +
            "than 5 or more than 15 symbols long.";
    public static final String MESSAGE_NO_SUCH_MEMBER = "No such member in this team!";
    private static final String MESSAGE_NO_SUCH_BOARD = "No such board in this team!";

    public String teamName;
    public List<Members> members;
    public List<Boards> boards;

    public TeamImpl(String teamName, List<Members> members, List<Boards> boards) {
        setTeamName(teamName);
        this.members = new ArrayList<>();
        this.boards = new ArrayList<>();
    }



    public String getTeamName() {
        return teamName;
    }

    public List<Members> getMembers() {
        return new ArrayList<>(members);
    }

    public List<Boards> getBoards() {
        return new ArrayList<>(boards);
    }

    private void setTeamName(String teamName) {
        if (teamName.trim().isEmpty()) {
            throw new IllegalArgumentException(MISSING_TEAM_NAME);
        }
        ValidationHelpers.validateStringLength(teamName, TEAMNAME_MIN_LEN, TEAMNAME_MAX_LEN,
                TEAMNAME_OUT_OF_RANGE_LEN);
        this.teamName = teamName;
    }

public void addMember(Members member) {
    for (int i = 0; i < members.size(); i++) {
        if (member.equals(members.get(i))) {
            System.out.printf(" %s is alredy part of a team",member);
            return;
        }
    }
    this.members.add(member);
}

    public void removeMember(MemberImpl member) {
        boolean isMemeber=false;
        for (int i = 0; i < members.size(); i++) {
            if (member.equals(members.get(i))) {
               isMemeber=true;
               members.remove(member);
            }
        if(isMemeber){
        }
            throw new IllegalArgumentException(MESSAGE_NO_SUCH_MEMBER);
        }

    }

public void addBoard(Boards board) {
    if (this.boards == null) {
        this.boards = new ArrayList<>();
    }
    if (this.boards.contains(board)) {
        System.out.println(board + " is already added to this team");
        return;
    }
    this.boards.add(board);
}

    public void removeBoard(BoardImpl board) {
        boolean isAlreadyExist=false;
        for (int i = 0; i < boards.size(); i++) {
            if (board.equals(boards.get(i))) {
                isAlreadyExist=true;
                boards.remove(board);
            }
            if(isAlreadyExist){
            }
            throw new IllegalArgumentException(MESSAGE_NO_SUCH_BOARD);
        }
    }
    public String getAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---- Teams Listing ----\n");
        stringBuilder.append("Team name: " +getTeamName() + "\n");
        if (members.isEmpty())  stringBuilder.append( "No members\n");
        else {
            stringBuilder.append("Team members: ");
            getMembers().stream().map(member -> member.getMemberName() + "; ").forEach(stringBuilder::append);
        }
        if (boards.isEmpty())  stringBuilder.append("No boards\n");
        else {
            stringBuilder.append("Team Boards: ");
            getBoards().stream().map(board -> board.getBoardName() + "; ").forEach(stringBuilder::append);
        }
        return  stringBuilder.toString();
    }

    public String toString(){ return getAsString();}
}