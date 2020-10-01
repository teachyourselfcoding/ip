package Parser;

import Command.*;
import exception.InvalidArgumentException;
import exception.InvalidCommandException;
import exception.InvalidIndexException;

/***
 Handle user commands and sort accordingly using command object
 ***/
public class Parser {
    public Command parseCommand(String line) throws InvalidCommandException, InvalidIndexException, InvalidArgumentException {
        String[] words = line.split(" ");
        Command command = null;
        switch (words[0]) {
            case "bye":
                command = new ByeCommand();
                break;
            case "list":
                command = new ListCommand();
                break;
            case "done":
                command = new DoneCommand(line.substring(5));
                break;
            case "delete":
                command = new DeleteTaskCommand(line.substring(7));
                break;
            case "save":
                command = new SaveCommand();
                break;
            case "find":
                command = new FindCommand(line.substring(5));
                break;
            case "todo":

            case "event":

            case "deadline":
                try{
                    command = new NewTaskCommand(words[0], line);
                } catch(IndexOutOfBoundsException e){
                    throw new InvalidArgumentException();
                } break;
            default:
                throw new InvalidCommandException();
        }
        return command;
    }
}