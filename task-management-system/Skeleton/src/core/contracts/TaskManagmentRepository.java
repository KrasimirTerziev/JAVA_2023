package core.contracts;

import models.interfaces.*;

import java.util.List;

public interface TaskManagmentRepository {

    List<Teams> getTeams();

    List<Members> getMembers();

    Teams createTeam(String teamName);

    Members createMember(String memberName);

    Teams addMemberToTeam(String memberName, String teamName);

    Comments createComment(String author, String message);

    Teams findTeamByName(String teamToFind);

    Boards findBoardbyName(String boardToFind);
    Tasks findTaskbyName(String taskToFind);

    List<Boards> getBoards();

    void addBoard(Teams team, String boardName);
    void addComment(Tasks task,Comments comments);

    Members findMemberByName(String memberName);

    void assignTaskToPerson(Members taskName, Tasks memberName);
    void unassignTaskFromMember(Tasks task);
}
