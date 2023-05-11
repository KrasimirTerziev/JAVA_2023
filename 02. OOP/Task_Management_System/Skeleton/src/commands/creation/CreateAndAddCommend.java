package commands.creation;

import commands.Command;
import core.contracts.TaskManagmentRepository;
import helpers.ValidationHelpers;
import models.interfaces.Comments;
import models.interfaces.Tasks;

import java.util.Collections;
import java.util.List;

public class CreateAndAddCommend implements Command {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;
    private static final String CREATED_MESSAGE = "New comment was created.\n \"" +
            "Comment  was added to  to task \"%s\"";
    private final TaskManagmentRepository taskManagmentRepository;


    public CreateAndAddCommend(TaskManagmentRepository taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }

    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String taskName = parameters.get(0);
        String author = parameters.get(1);
        String content = parameters.get(2);
        Comments comment = taskManagmentRepository.createComment(author, content);
        Tasks taskToAddComment = taskManagmentRepository.findTaskbyName(taskName);


        taskManagmentRepository.addComment(taskToAddComment, comment);

        return String.format(CREATED_MESSAGE,taskToAddComment);
    }
}
