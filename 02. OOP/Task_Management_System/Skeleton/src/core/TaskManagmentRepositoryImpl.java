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

    private static final String NO_SUCH_BOARD = "Board with name \"%s\" does not exist";
    private static final String NO_SUCH_TEAM = "Team with name \"%s\" does not exist!";
    private static final String NO_SUCH_TASK = "Task with name \"%s\" does not exist!";

    private List<Members> members;
    private List<Teams> teams;
    private List<Boards> boards;
    private List<Tasks> tasks;
    private List<Comments> comments;

    private List<String> activityhistory;


    //TODO constructor


    public TaskManagmentRepositoryImpl() {
        this.members = new ArrayList<>();
        this.boards = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.activityhistory = new ArrayList<>();
        this.teams = new ArrayList<>();
        this.comments = new ArrayList<>();

    }

    //getter
    public List<Teams> getTeams() {
        return new ArrayList<>(teams);
    }

    public List<Members> getMembers() {
        return new ArrayList<>(members);
    }

    public List<Boards> getBoards() {
        return new ArrayList<>(boards);
    }

    /**
     * Create Methods
     */
    public Teams createTeam(String teamName) {
        if (teams.contains(teamName)) throw new IllegalArgumentException(String.format(TEAM_ALREADY_EXISTS, teamName));
        Teams team = new TeamImpl(teamName, members, boards);
        this.teams.add(team);
        return team;
    }

    public Members createMember(String memberName) {
        if (members.contains(memberName))
            throw new IllegalArgumentException(String.format(MEMBER_ALREADY_EXISTS, memberName));
        Members member = new MemberImpl(memberName, tasks, activityhistory);
        this.members.add(member);
        return member;
    }

    public Comments createComment(String message, String author) {
        Comments comment = new CommentImpl(message, author);
        this.comments.add(comment);
        return comment;
    }

    /**
     * Add Methods
     */
    public Teams addMemberToTeam(String memberName, String teamName) {
        Members personToAdd = findMemberByName(memberName);
        Teams teamToAddMember = findTeamByName(teamName);
        teamToAddMember.getMembers().add(personToAdd);
        return teamToAddMember;
    }

    public void addBoard(Teams team, String boardName) {
        BoardImpl board = new BoardImpl(boardName, new ArrayList<>(), new ArrayList<>());
        team.getBoards().add(board);
        boards.add(board);
    }

    public void addComment(Tasks task, Comments comments) {
        task.getComments().add(comments);
    }


    //finders
    public Members findMemberByName(String personToFind) {
        return members
                .stream()
                .filter(m -> m.getMemberName().equalsIgnoreCase(personToFind))
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

    public Boards findBoardbyName(String boardToFind) {
        return boards
                .stream()
                .filter(board -> board.getBoardName().equalsIgnoreCase(boardToFind))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(NO_SUCH_BOARD, boardToFind)));
    }

    public Tasks findTaskbyName(String taskToFind) {
        return tasks
                .stream()
                .filter(task -> task.getTaskTitle().equalsIgnoreCase(taskToFind))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(NO_SUCH_TASK, taskToFind)));
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

    public void showAllBoards(List<BoardImpl> boards) {
        System.out.println("All team boards:");
        for (BoardImpl board : boards) {
            System.out.println("- " + board.getBoardName());
        }
    }

    //Members
    public void assignTaskToPerson(Members member, Tasks task) {
        task.setAssignedMember(member);
    }

    public void unassignTaskFromMember(Tasks task) {
        task.setAssignedMember(null);
    }

    public List<Tasks> getTasks() {
        return new ArrayList<>(tasks);
    }
}
