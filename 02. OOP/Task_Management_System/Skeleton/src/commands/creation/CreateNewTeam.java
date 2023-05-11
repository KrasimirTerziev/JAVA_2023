package commands.creation;


import commands.Command;
import core.contracts.TaskManagmentRepository;
import helpers.ValidationHelpers;
import models.interfaces.Teams;

import java.util.List;


public class CreateNewTeam implements Command {

    public static final String TEAM_ALREADY_EXISTS ="Team with name \"%s\" already exists! Choose different name!";
    public static final String TEAM_CREATED_MESSAGE = "Team \"%s\"  was created.";
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

    private final TaskManagmentRepository taskManagmentRepository;



    public CreateNewTeam(TaskManagmentRepository taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String teamName=parameters.get(0);
        for (Teams team: taskManagmentRepository.getTeams()) {
            if (team.getTeamName().equals(teamName))
                throw new IllegalArgumentException(String.format(TEAM_ALREADY_EXISTS, teamName));
        }
        Teams createdTeam = taskManagmentRepository.createTeam(teamName);

        return String.format(TEAM_CREATED_MESSAGE, createdTeam.getTeamName());
    }

    }

