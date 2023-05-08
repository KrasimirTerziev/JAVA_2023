package core;


import commands.addCommands.AddPersonToTeam;
import commands.creation.CreateNewPerson;
import commands.creation.CreateNewTeam;
import commands.showCommands.ShowAllTeamMembers;
import commands.showCommands.ShowAllTeamsCommand;
import core.CommandFactoryImpl;
import core.TaskManagmentRepositoryImpl;
import commands.Command;
import core.contracts.CommandFactory;
import core.contracts.CommandType;
import helpers.ParsingHelpers;

public class CommandFactoryImpl implements CommandFactory {

    @Override
    public Command createCommandFromCommandName(String commandTypeAsString, TaskManagmentRepositoryImpl taskManagmentRepositoryImpl) {
        CommandType commandType = ParsingHelpers.tryParseEnum(commandTypeAsString, CommandType.class);
        switch (commandType) {
            case SHOWTEAMS:
                return new ShowAllTeamsCommand(taskManagmentRepositoryImpl);
            case CREATETEAM:
                return new CreateNewTeam(taskManagmentRepositoryImpl);
            case CREATEPERSON:
               return new CreateNewPerson(taskManagmentRepositoryImpl);
            case ADDPERSONTOTEAM:
                return new AddPersonToTeam(taskManagmentRepositoryImpl);
            case SHOWALLTEAMMEMBERS:
                return new ShowAllTeamMembers(taskManagmentRepositoryImpl);
            default:
                throw new IllegalArgumentException();
        }
    }

}
