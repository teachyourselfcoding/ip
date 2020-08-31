import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        //Generates a greeting
        //greeting();
        Scanner in = new Scanner(System.in);
        String line;
        while(true) {
            line = in.nextLine();
            if (line.equals("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else {
                System.out.println(line);
            }
        }

    }

    public static void greeting(){
        String line = "____________________________________________________________";
        System.out.println(line);
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
        System.out.println(line);
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println(line);
    }
}
