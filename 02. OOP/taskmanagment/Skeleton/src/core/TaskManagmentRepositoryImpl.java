package core;

import core.contracts.TaskManagmentRepository;
import models.*;
import models.enums.Priority;
import models.enums.Severity;
import models.enums.Size;
import models.enums.Status;
import models.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class TaskManagmentRepositoryImpl implements TaskManagmentRepository {
    public static final String TEAM_ALREADY_EXISTS = "Team with name \"%s\" already exists! Choose different name!";

    public static final String MEMBER_ALREADY_EXISTS = "Team with name \"%s\" already exists! Choose different name!";
    private static final String NO_SUCH_MEMBER = "No such a member!";
    private static final String NO_SUCH_TEAM = "No such team!";

    private List<Members> members = new ArrayList<>();
    private final List<Teams> teams = new ArrayList<>();
    private List<Boards> boards= new ArrayList<>();
    private List<Tasks> tasks;

    private List<String> activityhistory;

    //getter
    public List<Teams> getTeams() {
        return new ArrayList<>(teams);
    }

    public List<Members> getMembers() {
        return new ArrayList<>(members);
    }

//    public List<Members> getTeamMembers(String teamName) {
//
//        return teamName;
//    }

    /**
     * Create Methods
     */
    public Teams createTeam(String teamName) {
        if (teams.contains(teamName)) throw new IllegalArgumentException(String.format(TEAM_ALREADY_EXISTS, teamName));
        Teams team = new TeamImpl(teamName,members, boards);
        this.teams.add(team);
        return team;
    }

    public Members createMember(String memberName) {
        if (members.contains(memberName))
            throw new IllegalArgumentException(String.format(MEMBER_ALREADY_EXISTS, memberName));
        Members member = new MemberImpl(memberName, tasks, activityhistory);
        return member;
    }

    /**
     * Add Methods
     */
    public Teams addMemberToTeam(String memberName, String teamName) {
        Members personToAdd = findMemberByName(memberName);
        findTeamByName(teamName).getMembers().add(personToAdd);
        return findTeamByName(teamName);
    }
    public Members findMemberByName(String personToFind) {
        return members
                .stream()
                .filter(member -> member.getMemberName().equalsIgnoreCase(personToFind))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(NO_SUCH_MEMBER, personToFind)));
    }
    public Teams findTeamByName(String teamToFind) {
        return teams
                .stream()
                .filter(team -> team.getTeamName().equalsIgnoreCase(teamToFind))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(NO_SUCH_TEAM, teamToFind)));
    }

   /* public void createBoardBug(int id, String taskTitle, String description, List<Comments> comments, List<String> history, Priority bugPriority,
                               Severity severity, Status bugStatus, Members bugAssignee) {
        BugImpl bug = createBug(id, taskTitle, description, comments, history, bugPriority, severity, bugStatus, bugAssignee);
        boards.add(bug);
    }

    public void createBoardStory(int id, String taskTitle, String description, List<Comments> comments, List<String> history, Priority storyPriority,
                                 Size size, Status storyStatus, Members storyAssignee) {
        StoryImpl story = createStory(id, taskTitle, description, comments, history, storyPriority, size, storyStatus, storyAssignee);
        boards.add(story);
    }

    public void createBoardFeedback(int id, String taskTitle, String description, List<Comments> comments, List<String> history, int rating, Status feedbackstatus) {
        FeedbackImpl feedback = createFeedback(id, taskTitle, description, comments, history, rating, feedbackstatus);
        boards.add(feedback);
    }
*/

    public BugImpl createBug(int id, String taskTitle, String description, List<Comments> comments, List<String> history, Priority bugPriority,
                             Severity severity, Status bugStatus, Members bugAssignee) {
        return new BugImpl(id, taskTitle, description, comments, history, bugPriority, severity, bugStatus, bugAssignee);
    }

    public StoryImpl createStory(int id, String taskTitle, String description, List<Comments> comments, List<String> history, Priority storyPriority,
                                 Size size, Status storyStatus, Members storyAssignee) {
        return new StoryImpl(id, taskTitle, description, comments, history, storyPriority, size, storyStatus, storyAssignee);
    }

    public FeedbackImpl createFeedback(int id, String taskTitle, String description, List<Comments> comments, List<String> history, int rating, Status feedbackstatus) {
        FeedbackImpl newFeedback = new FeedbackImpl(id, taskTitle, description, comments, history, rating, feedbackstatus);

        return newFeedback;
    }

    //Boards
    public void createBoard(String boardName) {
        BoardImpl board = new BoardImpl(boardName, new ArrayList<>(), new ArrayList<>());
        boards.add(board);
    }

    public void showAllBoards(List<BoardImpl> boards) {
        System.out.println("All team boards:");
        for (BoardImpl board : boards) {
            System.out.println("- " + board.getBoardName());
        }
    }

    public void showBoardActivity(BoardImpl board) {
        List<String> activityhistory = board.getActivityhistory();
        System.out.println("Activity for board '" + board.getBoardName() + "':");
        for (String activity : activityhistory) {
            System.out.println("- " + activity);
        }
    }

    //Members
    public void createNewMember(String memberName) {
        //create a new Person
        MemberImpl person = new MemberImpl(memberName, new ArrayList<>(), new ArrayList<>());
        members.add(person);
    }

    public void showMemberActivity(MemberImpl member) {
        //show Person Activity
        for (String activity : member.getActivityHistory()) {
            System.out.println(activity);
        }
    }

    public void showAllMembers(List<MemberImpl> members) {
        //show all People
        members.stream().forEach(member -> member.getMemberName());
        ;
        System.out.println();
        //  for (Members person : members){
        //     System.out.println(person.getMemberName());
        //  }
    }

    public void assignTaskToPerson(MemberImpl member, TaskImpl task) {
        //assign a task to a person
        member.addTask(task);
    }

    public void unassignTaskToPerson(MemberImpl member, TaskImpl task) {
        //unassign task to a person
        member.removeTask(task);
    }
}
