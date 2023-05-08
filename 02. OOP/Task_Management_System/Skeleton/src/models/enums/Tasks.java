package models.enums;

public enum Tasks {
    // TODO change the name
    BUG,
    STORY,
    FEEDBACK;


    @Override
    public String toString() {
        switch (this) {
            case BUG:
                return "Bug";
            case STORY:
                return "Story";
            case FEEDBACK:
                return "Feedback";
            default:
                throw new UnsupportedOperationException("Can't find tasks type.");
        }
    }
}
