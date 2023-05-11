package core;


import commands.addCommands.AddPersonToTeam;
import commands.creation.*;
import commands.showCommands.*;
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
            case ADDTEAMMEMBER:
                return new AddPersonToTeam(taskManagmentRepositoryImpl);
            case SHOWTEAMMEMBERS:
                return new ShowAllTeamMembers(taskManagmentRepositoryImpl);
            case SHOWUSERS:
                return new ShowAllPeople(taskManagmentRepositoryImpl);
            case SHOWPERSONACTIVITY:
                return new ShowPersonActivity(taskManagmentRepositoryImpl);
            case ADDCOMMENT:
                return new CreateAndAddCommend(taskManagmentRepositoryImpl);
            case CREATEBOARD:
                return new CreateNewBoard(taskManagmentRepositoryImpl);
            case SHOWBOARDS:
                return new ShowAllTeamBoards(taskManagmentRepositoryImpl);
            case SHOWBOARDACTIVITY:
                return new ShowBoardActivity(taskManagmentRepositoryImpl);
            case ASSIGNED:
                return new AsignTaskCommand(taskManagmentRepositoryImpl);
            case UNASSIGNED:
                return new UnassignedTaskCommand(taskManagmentRepositoryImpl);
            default:
                throw new IllegalArgumentException();
        }
    }

}
