package commands.showCommands;

import commands.Command;
import core.contracts.TaskManagmentRepository;
import helpers.ListingHelpers;
import models.interfaces.Members;
import models.interfaces.Teams;

import java.util.ArrayList;
import java.util.List;

public class ShowAllTeamMembers implements Command {


    private final List<Teams> teamsList;

    public ShowAllTeamMembers(TaskManagmentRepository taskManagmentRepository) {
        teamsList=taskManagmentRepository.getTeams();
    }

    @Override
    public String execute(List<String> parameters) {
        String teamMember= parameters.get(0);
        if(teamsList.isEmpty()){
            throw new IllegalArgumentException("Error");
        }
        return ListingHelpers.listAllMembersTeam(teamMember);
    }
}
