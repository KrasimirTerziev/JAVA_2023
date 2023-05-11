package commands.creation;

import commands.Command;
import core.TaskManagmentRepositoryImpl;
import helpers.ValidationHelpers;
import models.MemberImpl;
import models.TaskImpl;
import models.interfaces.Members;
import models.interfaces.Tasks;

import java.util.List;

public class UnassignedTaskCommand implements Command {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private TaskManagmentRepositoryImpl taskManagmentRepository;

    public UnassignedTaskCommand(TaskManagmentRepositoryImpl taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String taskName = parameters.get(0);
        String memberName = parameters.get(1);

        Tasks task = taskManagmentRepository.findTaskbyName(taskName);

        taskManagmentRepository.unassignTaskFromMember(task);

        return "User: " + memberName + " has no task.";
    }
}
