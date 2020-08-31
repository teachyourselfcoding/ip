import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        request();
        //Generates a greeting
        //greeting();


    }

    public static void request(){
        Scanner in = new Scanner(System.in);
        String[] list = new String[100];
        String line;

        int i=0,j=0;

        while(true) {
            line = in.nextLine();
            if (line.equals("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }else if(line.equals("list")){
                for(j=0;j<i;j++){
                    System.out.println((j+1)+". "+list[j]);
                }
            }else {
                list[i] = line;
                System.out.println("added: "+ line);
                i++;
            }
        }
    }

}