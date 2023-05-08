package helpers;


import commands.CommandsConstants;
import core.TaskManagmentRepositoryImpl;
import models.interfaces.Members;
import models.interfaces.Teams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListingHelpers {

    public static String listAllTeams(List<Teams> teams) {
        List<String> result = new ArrayList<>();
        for (Teams team : teams) {
            result.add(team.toString());
        }

        return String.join(CommandsConstants.JOIN_DELIMITER + System.lineSeparator(), result).trim();
    }
    public static String listAllMembersTeam( String parameter) {
        List<String> result = new ArrayList<>();
        Teams team1=new TaskManagmentRepositoryImpl().findTeamByName(parameter);
        for (Members member : team1.getMembers()) {
            result.add(member.toString());
        }

        return String.join(CommandsConstants.JOIN_DELIMITER + System.lineSeparator(), result).trim();
    }




}
