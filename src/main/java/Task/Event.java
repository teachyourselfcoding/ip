package Task;

public class Event extends Task {
    public Event(String description, String date) {
        super(description);
        this.date=date;
        this.type = 'E';
    }

    @Override
    public String toString() {
        return "[E]" + super.toString()+ "(" + this.date + ")";
    }
}
