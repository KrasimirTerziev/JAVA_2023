package models;

import models.enums.Priority;
import models.enums.Size;
import models.enums.Status;
import models.enums.Tasks;
import models.interfaces.Boards;
import models.interfaces.Comments;
import models.interfaces.Members;
import models.interfaces.Story;

import java.util.List;

public class StoryImpl extends TaskImpl implements Story {
   private Priority storyPriority;
    private  Size size;

    private Status storyStatus;
    private  Members storyAssignee;



    public StoryImpl(int id, String taskTitle, String description, List<Comments> comments, List<String> history, Priority storyPriority,
                     Size size, Status storyStatus, Members storyAssignee) {
        super(id, taskTitle, description, comments, history);
        setStoryPriority(storyPriority);
        setSize(size);
        setStoryStatus(storyStatus);
        setStoryAssignee(storyAssignee);
    }

    public Priority getStoryPriority() {
        return storyPriority;
    }

    public void setStoryPriority(Priority storyPriority) {
        this.storyPriority = storyPriority;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Status getStoryStatus() {
        return storyStatus;
    }

    public void setStoryStatus(Status storyStatus) {
        this.storyStatus = storyStatus;
    }

    public Members getStoryAssignee() {
        return storyAssignee;
    }

    public void setStoryAssignee(Members storyAssignee) {
        this.storyAssignee = storyAssignee;
    }
}
