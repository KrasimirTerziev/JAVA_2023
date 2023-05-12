package commands.showCommands;

import commands.Command;
import core.contracts.TaskManagmentRepository;
import helpers.ValidationHelpers;
import models.interfaces.Boards;
import models.interfaces.Teams;

import java.util.List;

public class ShowTeamActivity implements Command {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private static final String NO_BOARD_MESSAGE = "This team don`t have a boards!";
    private static final String NO_BOARD_ACTIVITY = "This board don`t have a activity!";
    private TaskManagmentRepository taskManagmentRepository;

    public ShowTeamActivity(TaskManagmentRepository taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }


    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String teamName = parameters.get(0);
        StringBuilder result = new StringBuilder();
        Teams team = taskManagmentRepository.findTeamByName(teamName);
        if (team.getBoards().isEmpty()) {
            throw new IllegalArgumentException(NO_BOARD_MESSAGE);
        }
        for (int i = 0; i < team.getBoards().size(); i++) {
            Boards board = team.getBoards().get(i);
            if (board.getActivityhistory().isEmpty()) {
                throw new IllegalArgumentException(NO_BOARD_ACTIVITY);
            }
            for (int j = 0; j < board.getActivityhistory().size(); j++) {
                result.append(j + 1).append(". ");
                result.append(board.getActivityhistory());
            }

        }

        return result.toString();
    }
}
