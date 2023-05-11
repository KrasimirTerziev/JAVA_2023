package commands.showCommands;

import commands.Command;
import core.contracts.TaskManagmentRepository;
import helpers.ValidationHelpers;
import models.interfaces.Boards;
import models.interfaces.Members;
import models.interfaces.Teams;

import java.util.List;

public class ShowAllTeamBoards implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private TaskManagmentRepository taskManagmentRepository;

    public ShowAllTeamBoards(TaskManagmentRepository taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }



    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);
        String teamName = parameters.get(0);
        StringBuilder result = new StringBuilder();
        Teams team = taskManagmentRepository.findTeamByName(teamName);
        result.append("---- Teams Boards ----\n");
        result.append("Team name: " +teamName + "\n");
        if (team.getBoards().isEmpty())  result.append( "No boards on this team\n");
        else {
            result.append("Team Boards: ");
            team.getBoards().stream().map(boards -> boards.getBoardName() + "; ").forEach(result::append);
        }
        return  result.toString();
    }


}
