public class Task {
    protected String description;
    protected char type;
    protected boolean isDone;
    protected String date;
    protected int listCount;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.listCount = 0;
        this.type = ' ';
        this.date = " none";
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