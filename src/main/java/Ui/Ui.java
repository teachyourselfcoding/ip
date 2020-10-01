package Ui;

import Task.Task;

import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;

public class Ui {

    public static final String ERROR_MESSAGE_IOEXCEPTION = "Load Error";
    public static final String ERROR_MESSAGE_NO_DESC = "Description missing";
    public static final String ERROR_MESSAGE_NO_DATE = "Date is missing";
    public static final String ERROR_MESSAGE_INVALID_COMMAND = "I don't know what that means";
    public static final String ERROR_MESSAGE_NO_NUM = "No number detected";
    public static final String ERROR_MESSAGE_NO_TASK = "Unable to locate task";

    public static final String STORAGE_MESSAGE_SUCCESSFUL_SAVE = "Successfully saved to file";
    public static final String STORAGE_MESSAGE_SUCCESSFUL_LOAD = "File loaded successfully";
    public static final String STORAGE_MESSAGE_NEW_FILE_MESSAGE = "File not found. New file created";

    public static final String TASK_MESSAGE_MARKED_DONE = "Nice! I've marked this task as done:";
    public static final String TASK_MESSAGE_TASK_FOUND = "Here are the matching tasks in your list: ";
    private final Scanner in;

    public Ui() {
        in = new Scanner(System.in);
    }

    public String readCommand() {
        return in.nextLine();
    }

    /***
     Prints goodbye message
     ***/
    public void bidGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /***
     Prints greet message message
     ***/
    public static void greet() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    /***
     Prints out entire list
     ***/
    public static void printList(ArrayList<Task> list) {
        int i;
        for (i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "." + list.get(i));
        }
    }

    public static void printNewFileMessage(){
        System.out.println(STORAGE_MESSAGE_NEW_FILE_MESSAGE);
    }

    /***
     Prints invalid command error message
     ***/
    public static void printInvalidCommandMessage() {

        System.out.println(ERROR_MESSAGE_INVALID_COMMAND);
    }

    /***
     Prints no date error message
     ***/
    public static void printErrorNoDateMessage() {
        System.out.println(ERROR_MESSAGE_NO_DATE);

    }

    /***
     Prints Task marked done message
     ***/
    public static void printDoneTaskMessage(){

        System.out.println(TASK_MESSAGE_MARKED_DONE);
    }

    /***
     Prints Task missing error message
     ***/
    public static void printTaskMissingMessage(){

        System.out.println(ERROR_MESSAGE_NO_TASK);
    }

    /***
     Prints Task found message
     ***/
    public static void printTaskFoundMessage(){

        System.out.println(TASK_MESSAGE_TASK_FOUND);
    }

    /***
     Prints no description error message
     ***/
    public static void printErrorNoDescriptionMessage() {

        System.out.println(ERROR_MESSAGE_NO_DESC);
    }

    /***
     Prints no number error message
     ***/
    public static void printErrorNoNumMessage() {

        System.out.println(ERROR_MESSAGE_NO_NUM);

    }


    /***
     Prints loading error message
     ***/
    public static void printLoadErrorMessage() {

        System.out.println(ERROR_MESSAGE_IOEXCEPTION);
    }

    /***
     Prints loading success message
     ***/
    public static void printLoadSuccessMessage() {
        System.out.println(STORAGE_MESSAGE_SUCCESSFUL_LOAD);
    }

    /***
     Prints saving success message
     ***/
    public static void printSaveSuccessMessage() {
        System.out.println(STORAGE_MESSAGE_SUCCESSFUL_SAVE);
    }
}




