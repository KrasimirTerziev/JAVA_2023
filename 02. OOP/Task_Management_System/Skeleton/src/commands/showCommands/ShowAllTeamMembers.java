package commands.showCommands;

import commands.Command;
import commands.CommandsConstants;
import core.contracts.TaskManagmentRepository;
import helpers.ListingHelpers;
import helpers.ValidationHelpers;
import models.interfaces.Members;
import models.interfaces.Teams;

import java.util.ArrayList;
import java.util.List;

public class ShowAllTeamMembers implements Command {

    private TaskManagmentRepository taskManagmentRepository;
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

    public ShowAllTeamMembers(TaskManagmentRepository taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }

    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String teamName = parameters.get(0);
        StringBuilder result = new StringBuilder();
        Teams team = taskManagmentRepository.findTeamByName(teamName);
        result.append("---- Teams Members ----\n");
        result.append("Team name: " +teamName + "\n");
        if (team.getMembers().isEmpty())  result.append( "No members on this team\n");
        else {
            result.append("Team Members: ");
            team.getMembers().stream().map(members -> members.getMemberName() + "; ").forEach(result::append);
        }
        return  result.toString();
    }


}
