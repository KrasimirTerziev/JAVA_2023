package commands.creation;

import commands.Command;
import core.contracts.TaskManagmentRepository;
import helpers.ValidationHelpers;
import models.interfaces.Boards;
import models.interfaces.Comments;
import models.interfaces.Teams;

import java.util.List;

public class CreateNewBoard implements Command {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private final TaskManagmentRepository taskManagmentRepository;


    public CreateNewBoard(TaskManagmentRepository taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String BoardName = parameters.get(0);
        String TeamName = parameters.get(1);
        Teams team = taskManagmentRepository.findTeamByName(TeamName);
        taskManagmentRepository.addBoard(team, BoardName);


        return String.format("Board with name %s was created succesfully and added to team %s", BoardName,TeamName );
    }
}


