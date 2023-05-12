package commands.creation;

import commands.Command;
import core.TaskManagmentRepositoryImpl;
import core.contracts.TaskManagmentRepository;
import helpers.ValidationHelpers;
import models.MemberImpl;
import models.TaskImpl;
import models.interfaces.Boards;
import models.interfaces.Members;
import models.interfaces.Tasks;
import models.interfaces.Teams;

import java.util.List;

public class AsignTaskCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private TaskManagmentRepository taskManagmentRepository;

    public AsignTaskCommand(TaskManagmentRepositoryImpl taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String taskName = parameters.get(0);
        String memberName = parameters.get(1);
        String boardName = parameters.get(2);

        Tasks task = taskManagmentRepository.findTaskbyName(taskName);
        Members user = taskManagmentRepository.findMemberByName(memberName);
        Teams team = taskManagmentRepository.findTeamByMemberName(memberName);
        Boards board = taskManagmentRepository.findBoardbyName(boardName);


        taskManagmentRepository.assignTaskToPerson(user, task, board);
     //   System.out.println("Task : " + taskName + " assigned to member: " + memberName + " in team: " + team.getTeamName());
        return "Task " + taskName + "assigned to member " + memberName + " in team:" + team.getTeamName() + " in board: "
        + board.getBoardName();
    }
}
