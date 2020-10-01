package TaskManager;
import Task.Deadline;
import Task.Event;
import Task.Task;
import Task.ToDo;
import Ui.Ui;
import java.util.ArrayList;

public class TaskManager {

    private static ArrayList<Task> list = new ArrayList<>();

    public TaskManager(){
        list = new ArrayList<>();
    }

    public TaskManager(ArrayList<Task> list){
        this.list = list;
    }
    /***
     Prints all task in the Arraylist
     ***/
    public void printList(){
        Ui.printList(list);
    }

    /***
     Mark task as done
     ***/
    public static void markDone(int index) {
        try {
            Task task = list.get(index-1);
            task.isDone = true;
            Ui.printDoneTaskMessage();
            System.out.println("[✓] " + list.get(index - 1).description);
            System.out.println("Now you have " + list.size() + " tasks in the list");
        }catch (ArrayIndexOutOfBoundsException e) {
            Ui.printTaskMissingMessage();
        }
    }

    /***
     Delete Task from Arraylist
     ***/
    public static void Delete(int index){
        Task task = list.get(index-1);
        list.remove(index-1);
        System.out.println("Removed: " + task.description);
        System.out.println("Now you have: " + list.size() + " task(s) in your list!");
    }

    /***
     Find Task from Arraylist
     ***/
    public static void Find (String description){
        int findCount = 0;
        Ui.printTaskFoundMessage();
        for (Task task : list) {
            if ((task.description).contains(description)) {
                findCount++;
                System.out.println(findCount + "." + task);
            }
        }
    }

    /***
     Add task to Arraylist
     ***/
    public void addTask(String taskType, String line){
        Task newTask;
        String[] detailsWords;
        int index = line.indexOf('/');
        try {
            switch(taskType) {
                case "deadline":
                    newTask = new Deadline(line.substring(9, index), line.substring(index + 1));
                    break;
                case "event":
                    newTask = new Event(line.substring(6, index), line.substring(index + 1));
                    break;
                default:
                    newTask = new ToDo(line.substring(5));
            }
            list.add(newTask);

            System.out.println("Got it. I've added this task: "+ newTask.description);
            System.out.println("Now you have " + list.size() + " tasks in the list");

        } catch (IndexOutOfBoundsException e){
            Ui.printErrorNoDateMessage();
        }
    }
    /***
     Return all the task in Arraylist
     ***/
    public ArrayList<Task> getTasks(){
        return list;
    }


}
