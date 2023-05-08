package commands.showCommands;

import commands.Command;
import core.contracts.TaskManagmentRepository;
import models.MemberImpl;

import java.util.List;

public class ShowAllPeople implements Command {
    private final TaskManagmentRepository taskManagmentRepository;
    private final List<MemberImpl> members;

    public ShowAllPeople(TaskManagmentRepository taskManagmentRepository, List<MemberImpl> members) {
        this.taskManagmentRepository = taskManagmentRepository;
        this.members = members;
    }

    public String execute(List<String> parameters) {
        return null;
    }
}
