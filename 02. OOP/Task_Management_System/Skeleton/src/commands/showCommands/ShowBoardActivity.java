package commands.showCommands;

import commands.Command;
import core.contracts.TaskManagmentRepository;
import helpers.ValidationHelpers;
import models.interfaces.Boards;
import models.interfaces.Members;
import models.interfaces.Teams;

import java.util.List;

public class ShowBoardActivity implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private TaskManagmentRepository taskManagmentRepository;

    public ShowBoardActivity(TaskManagmentRepository taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }



    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);
        String boardName = parameters.get(0);
        StringBuilder result = new StringBuilder();
        Boards boards = taskManagmentRepository.findBoardbyName(boardName);
        result.append("---- Boards Activity ----\n");
        result.append("Board name: " +boardName + "\n");
        if (boards.getActivityhistory().isEmpty())  result.append( "No activity history on this board\n");
        else {
            result.append("Board Activity: ");
            boards.getActivityhistory().stream().map(activity -> boards.getActivityhistory() + "; ").forEach(result::append);
        }
        return  result.toString();
    }


}
