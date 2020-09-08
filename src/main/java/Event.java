public class Event extends Task {
    public Event(String description, String deadline) {
        super(description);
        this.deadline=deadline;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString()+ "(" + this.deadline + ")";
    }
}
