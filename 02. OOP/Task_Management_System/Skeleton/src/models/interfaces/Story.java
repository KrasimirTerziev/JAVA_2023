package models.interfaces;

import models.enums.Priority;
import models.enums.Size;
import models.enums.Status;

public interface Story {
    Priority getStoryPriority();
    Size getSize();
    Status getStoryStatus();

    Members getStoryAssignee();


}
