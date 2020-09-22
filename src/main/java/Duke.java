//package duke;

//import duke.task.Deadline;
//import duke.task.Event;
//import duke.task.Task;
//import duke.task.ToDo;

import java.io.FileWriter;
import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Duke {
    public static final String filePath = "duke.txt";
    public static int listCount = 0;
    public static ArrayList<Task> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        //Generates a greeting
        greet();
        fileLoad();
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
            task.isDone = true;
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
            newTask.type = 'T';
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
            newTask.type = 'E';
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
            Task newTask = new Deadline(line.substring(0, index), line.substring(index + 1));
            newTask.type = 'D';
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


    public static void fileLoad() throws IOException {
        File dataFile = new File(filePath);
        if (dataFile.createNewFile()) {
            System.out.println("Since the file does not exist, I have created a file for you.");
        }
        Scanner dataScanner = new Scanner(dataFile);

        while (dataScanner.hasNext()) {
            String data = dataScanner.nextLine();
            String type = data.substring(0,1);
            String info = data.substring(8);
            int dateIndex = info.indexOf('|');
            switch(type){
                case "D":
                    Task newDeadline = new Deadline(info.substring(0, dateIndex), info.substring(dateIndex + info.length()-1));
                    newDeadline.type = 'D';
                    newDeadline.isDone = data.charAt(4)=='1';
                    list.add(newDeadline);
                    break;
                case "T":
                    Task newTodo = new ToDo(info);
                    newTodo.type = 'T';
                    newTodo.isDone = data.charAt(4)=='1';
                    list.add(newTodo);
                    break;
                case "E":
                    Task dateEvent = new Event(info.substring(0, dateIndex), info.substring(dateIndex + info.length()-1));
                    dateEvent.type = 'D';
                    dateEvent.isDone = data.charAt(4)=='1';
                    list.add(dateEvent);
                    break;
                default:
                    break;
            }
        }

    }
    public static void Save(){
        final String FILE_DIR = "data";
        final String FILE_PATH = "data/data.txt";

        FileWriter writer;
        File fileDir = new File(FILE_DIR);

        if (!fileDir.exists()){
            fileDir.mkdir();
        }

        try {
            writer = new FileWriter(FILE_PATH);
            for (Task task : list) {
                writer.write(task.type + " | " + task.isDone + " | "
                        + task.description + " | " + task.date + System.lineSeparator());
            }
            writer.close();
            System.out.println("Successfully saved to file!");
        } catch (IOException e){
            e.printStackTrace();
        }
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
                case "save":
                    Save();
                    break;
                default:
                    System.out.println("I don't know what that means");
                    break;
            }
        }
    }





}

