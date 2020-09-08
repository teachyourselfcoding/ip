public class Deadline extends Task {
    public Deadline(String description, String deadline) {
        super(description);
        this.deadline=deadline;
    }

    @Override
    public String toString() {
        return "[D]"  + super.toString() + "(" + this.deadline + ")";
    }
}
