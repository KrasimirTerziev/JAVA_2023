package models.interfaces;

import models.BoardImpl;
import models.interfaces.Members;

import java.util.List;

public interface Teams  {

    String getTeamName();

    List<Members> getMembers();

    List<Boards> getBoards();
}
