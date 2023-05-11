package commands.showCommands;

import commands.Command;
import commands.CommandsConstants;
import core.contracts.TaskManagmentRepository;
import helpers.ListingHelpers;
import models.interfaces.Teams;

import java.util.ArrayList;
import java.util.List;

public class ShowAllTeamsCommand implements Command {

    private List<Teams> teams;

    public ShowAllTeamsCommand(TaskManagmentRepository taskManagmentRepository) {
        this.teams = taskManagmentRepository.getTeams();
    }

    @Override
    public String execute(List<String> parameters) {
        List<String> result = new ArrayList<>();
        for (Teams team : teams) {
            result.add(team.toString());
        }
    return String.join(CommandsConstants.JOIN_DELIMITER + System.lineSeparator(),result).trim();

    }
}
