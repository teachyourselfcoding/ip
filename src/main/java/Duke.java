import java.util.Scanner;


public class Duke {
    public static int listCount = 0;
    public static Task[] list = new Task[100];


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
            System.out.println(listCount + "." + list[i]);
        }
    }

    public static void markDone(String word){
        int num = Integer.parseInt(word);
        list[num - 1].isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[✓] " + list[num - 1].description);
        System.out.println("Now you have " + listCount + " tasks in the list");
    }

    public static void todo(String line){
        list[listCount] = new ToDo(line);
        System.out.println("Got it. I've added this task:");
        System.out.println(list[listCount]);
        System.out.println("Now you have " + listCount + " tasks in the list");
        listCount++;
    }

    public static void Event(String line){
        int index = line.indexOf('/');
        list[listCount] = new Event(line.substring(0,index-1),line.substring(index+1));
        System.out.println("Got it. I've added this task:");
        System.out.println(list[listCount]);
        System.out.println("Now you have " + listCount + " tasks in the list");
        listCount++;
    }

    public static void Deadline(String line){
        int index = line.indexOf('/');
        list[listCount] = new Deadline(line.substring(0,index-1),line.substring(index+1));
        System.out.println("Got it. I've added this task:");
        System.out.println(list[listCount]);
        System.out.println("Now you have " + listCount + " tasks in the list");
        listCount++;
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
                default:
                    System.out.println("Command not supported");
            }
        }
    }



}