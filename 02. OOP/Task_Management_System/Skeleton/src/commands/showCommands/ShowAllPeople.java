package commands.showCommands;

import commands.Command;
import commands.CommandsConstants;
import core.contracts.TaskManagmentRepository;
import helpers.ListingHelpers;
import helpers.ValidationHelpers;
import models.MemberImpl;
import models.interfaces.Members;

import java.util.ArrayList;
import java.util.List;

public class ShowAllPeople implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 0;
    private TaskManagmentRepository taskManagmentRepository;

    public ShowAllPeople(TaskManagmentRepository taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        return showPeople();
    }

    public String showPeople() {
        StringBuilder output = new StringBuilder();
        List<Members> members = taskManagmentRepository.getMembers();
        for (Members member : members) {
            output.append(member.toString()).append(System.lineSeparator());
        }
        return output.toString();
    }
}
