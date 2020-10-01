package Task;

public class Task {
    public String description;
    public char type;
    public boolean isDone;
    public String date;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.type = ' ';
        this.date = " ";
    }
    public String statusicon(){

        return (this.isDone?"[✓]":"[✗]");
    }
//    public void markDone(){
//        this.isDone = true;
//    }


    @Override
    public String toString(){
        return  statusicon() + description;
    }


}