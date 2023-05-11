package core.contracts;

import commands.Command;
import core.TaskManagmentRepositoryImpl;

public interface CommandFactory {

    Command createCommandFromCommandName(String commandTypeAsString, TaskManagmentRepositoryImpl taskManagmentRepository);

}
