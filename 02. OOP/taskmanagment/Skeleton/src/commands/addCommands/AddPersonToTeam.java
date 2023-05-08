package commands.addCommands;

import commands.Command;
import core.contracts.TaskManagmentRepository;
import helpers.ValidationHelpers;
import models.interfaces.Teams;

import java.util.List;
import java.util.Locale;

public class AddPersonToTeam implements Command {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String ADDMEMBЕR_MESSAGE = "Member \"%s\" was added to Team \"%s\" ";

    private final TaskManagmentRepository taskManagmentRepository;

    private String memberName;
    private String teamName;

    public AddPersonToTeam(TaskManagmentRepository taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }


    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        teamName = parameters.get(0);
        memberName = parameters.get(1);
        Teams createdTeam = taskManagmentRepository.addMemberToTeam(memberName, teamName);
        return String.format(ADDMEMBЕR_MESSAGE, memberName, createdTeam.getTeamName());

    }

}
