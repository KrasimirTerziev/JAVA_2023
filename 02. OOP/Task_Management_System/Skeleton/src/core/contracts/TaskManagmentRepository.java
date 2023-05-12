package core.contracts;

import models.enums.Priority;
import models.enums.Severity;
import models.enums.Status;
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

    Teams findTeamByMemberName(String memberName);
    List<Boards> findBoardsByMemberName(String memberName);

   void  assignTaskToPerson(Members member, Tasks task, Boards board);
    void unassignTaskFromMember(Tasks task);

    Bugs createBug(String taskTitle, String description, List<Comments> comments, List<String> history, Priority bugPriority,
                   Severity severity, Status bugStatus, Members bugAssignee);
}
