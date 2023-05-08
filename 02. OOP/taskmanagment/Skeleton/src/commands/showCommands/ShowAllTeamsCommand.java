package commands.showCommands;

import commands.Command;
import core.contracts.TaskManagmentRepository;
import helpers.ListingHelpers;
import models.interfaces.Teams;

import java.util.ArrayList;
import java.util.List;

public class ShowAllTeamsCommand implements Command {

    private List<Teams> teams=new ArrayList<>();

    public ShowAllTeamsCommand(TaskManagmentRepository taskManagmentRepository) {
        this.teams = taskManagmentRepository.getTeams();
    }

    @Override
    public String execute(List<String> parameters) {

        return ListingHelpers.listAllTeams(teams);
    }
}
