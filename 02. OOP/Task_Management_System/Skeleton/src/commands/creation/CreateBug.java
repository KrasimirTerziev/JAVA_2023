package commands.creation;

import commands.Command;
import core.contracts.TaskManagmentRepository;
import models.enums.Priority;
import models.enums.Severity;
import models.enums.Status;
import models.interfaces.Bugs;
import models.interfaces.Comments;
import models.interfaces.Members;

import java.util.ArrayList;
import java.util.List;

public class CreateBug implements Command {

    private final TaskManagmentRepository taskManagmentRepository;

    public static final String TEAM_CREATED_MESSAGE = "Bug with name \"%s\" was created.";

    public CreateBug(TaskManagmentRepository taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }




    @Override
    public String execute(List<String> parameters) {
        String tasktitle = parameters.get(0);
        String description = parameters.get(1);
        List<Comments>  comments = new ArrayList<>();
        List<String> history = new ArrayList<>();
        Priority bugpriority = Priority.valueOf(parameters.get(2));
        Severity severity = Severity.valueOf(parameters.get(3));
        Status bugstatus = Status.valueOf(parameters.get(4));
        Members bugassignee = null;
        Bugs bug = taskManagmentRepository.createBug(tasktitle, description, comments, history, bugpriority, severity,
                bugstatus, bugassignee);
        return String.format(TEAM_CREATED_MESSAGE, bug.GetBugTitle());
    }
}
