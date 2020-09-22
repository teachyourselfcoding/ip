//package duke;

//import duke.task.Deadline;
//import duke.task.Event;
//import duke.task.Task;
//import duke.task.ToDo;

import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;

public class Duke {
    public static int listCount = 0;
    public static ArrayList<Task> list = new ArrayList<>();


    public static void main(String[] args) {
        //Generates a greeting
        greet();
        request();
    }

    public static void bidGoodbye(){
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void printList(){
        int i;
        for (i = 0; i < listCount; i++) {
            System.out.println((i+1) + "." + list.get(i));
        }
    }

    public static void markDone(String word) {
        try {
            int num = Integer.parseInt(word);
            Task task = list.get(num);
            task.markDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("[✓] " + list.get(num - 1).description);
            System.out.println("Now you have " + listCount + " tasks in the list");
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot find the task");
        }
    }

    public static void todo(String line) {
        try {
            Task newTask = new ToDo(line);
            list.add(newTask);
            listCount++;
            System.out.println("Got it. I've added this task:");
            System.out.println(line);
            System.out.println("Now you have " + listCount + " tasks in the list");

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("____________________________________________________________\n" +
                    "0x00002639 OOPS!!! The description of a todo cannot be empty.");
            System.out.println("____________________________________________________________\n");
        }
    }

    public static void Event(String line){
        try{
            int index = line.indexOf('/');
            Task newTask = new Event(line.substring(0, index), line.substring(index + 1));
            list.add(newTask);
            System.out.println("Got it. I've added this task: "+list.get(listCount).description);
            listCount++;
            System.out.println("Now you have " + listCount + " tasks in the list");

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("____________________________________________________________\n" +
                    "☹ OOPS!!! The description of an event cannot be empty.");
            System.out.println("____________________________________________________________\n");
        }
    }

    public static void Deadline(String line) {
        try {
            int index = line.indexOf('/');
//            Task task = list.get(listCount);
            Task newTask = new Deadline(line.substring(0, index), line.substring(index + 1));
            list.add(newTask);
            System.out.println("Got it. I've added this task:");
            System.out.println(list.get(listCount).description);
            listCount++;
            System.out.println("Now you have " + listCount + " tasks in the list");

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("____________________________________________________________\n" +
                    "☹ OOPS!!! The description of a deadline cannot be empty.");
            System.out.println("____________________________________________________________\n");
        }
    }

    public static void Delete(String taskNumber){
        int num = Integer.parseInt(taskNumber);
        Task task = list.get(num-1);
        list.remove(num-1);
        System.out.println("Removed: " + task.description);
        System.out.println("Now you have: " + list.size() + " task(s) in your list!");
    }


    public static void greet(){
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public static void request() {
        Scanner in = new Scanner(System.in);
        String line;
        while (true) {
            line = in.nextLine();
            String [] words = line.split(" ");
            switch (words[0]) {
                case "bye":
                    bidGoodbye();
                    break;
                case "list":
                    printList();
                    break;
                case "done":
                    markDone(line.substring(5));
                    break;
                case "todo":
                    todo(line.substring(5));
                    break;
                case "event":
                    Event(line.substring(6));
                    break;
                case "deadline":
                    Deadline(line.substring(9));
                    break;
                case "delete":
                    Delete(line.substring(7));
                    break;
                default:
                    System.out.println("I don't know what that means");
                    break;
            }
        }
    }





}

