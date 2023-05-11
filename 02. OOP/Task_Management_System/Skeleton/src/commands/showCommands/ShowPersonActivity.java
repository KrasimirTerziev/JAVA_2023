package commands.showCommands;

import commands.Command;
import core.contracts.TaskManagmentRepository;
import helpers.ValidationHelpers;
import models.MemberImpl;
import models.interfaces.Members;

import java.util.List;

public class ShowPersonActivity implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 0;
    private TaskManagmentRepository taskManagmentRepository;

    public ShowPersonActivity(TaskManagmentRepository taskManagmentRepository) {
        this.taskManagmentRepository = taskManagmentRepository;
    }

    @Override
    public String execute(List<String> parameters) {
       ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        return showActivity();
    }

    public String showActivity() {
        StringBuilder output = new StringBuilder();
        List<Members> members = taskManagmentRepository.getMembers();

        for(Members member : members){
            output.append("Activity for member: ").append(member.getMemberName()).append("\n");
            for (String activity : member.getActivityHistory()){
                output.append(activity).append("\n");
            }
        }
        return output.toString();
    }
}
