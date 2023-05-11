package commands.creation;

import commands.Command;
import core.contracts.TaskManagmentRepository;
import helpers.ValidationHelpers;
import models.interfaces.Members;
import models.interfaces.Teams;

import java.util.List;

public class CreateNewPerson implements Command {

    public static final String MEMBER_ALREADY_EXISTS ="Person with name \"%s\" already exists! Choose different name!";
    public static final String MEMBER_CREATED_MESSAGE = "Person \"%s\" was created.";

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private final TaskManagmentRepository taskManagmentRepository;


    public CreateNewPerson(TaskManagmentRepository taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String memberName=parameters.get(0);
        Members person = taskManagmentRepository.createMember(memberName);

        return String.format(MEMBER_CREATED_MESSAGE, person.getMemberName());
    }
}
