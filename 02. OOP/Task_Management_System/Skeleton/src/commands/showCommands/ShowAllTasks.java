package commands.showCommands;

import commands.Command;
import core.contracts.TaskManagmentRepository;
import helpers.ValidationHelpers;
import models.interfaces.Boards;
import models.interfaces.Teams;

import java.util.List;

public class ShowAllTasks implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private TaskManagmentRepository taskManagmentRepository;

    public ShowAllTasks(TaskManagmentRepository taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }



    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);
        String memberName = parameters.get(0);
        StringBuilder result = new StringBuilder();
     //   List<Boards> board = taskManagmentRepository.findBoardsByMemberName(memberName);
        Boards board = taskManagmentRepository.findBoardbyName(memberName);
        result.append("---- Board Tasks ----\n");
        result.append("Board name: " +memberName + "\n");
            result.append("Boards Tasks: " +board.getTasks());
        return  result.toString();
    }
}
