package core.contracts;

import models.interfaces.Members;
import models.interfaces.Teams;

import java.util.List;

public interface TaskManagmentRepository {

    List<Teams> getTeams();

    List<Members> getMembers();

    Teams createTeam(String teamName);

 //   List<Members> getTeamMembers(String teamName);

    Members createMember(String memberName);
    Teams addMemberToTeam(String memberName, String teamName);
}
