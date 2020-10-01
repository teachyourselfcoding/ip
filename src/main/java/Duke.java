import Ui.Ui;
import Command.Command;
import Parser.Parser;
import Storage.Storage;
import TaskManager.TaskManager;

import exception.*;

import java.lang.String;
import java.io.IOException;


public class Duke {

    private static final String FILE_PATH = "data/duke.txt";
    private final Ui ui;
    private final Storage storage;
    private TaskManager taskManager;

    public Duke() {
        ui = new Ui();
        storage = new Storage(FILE_PATH);

        try {
            storage.checkFileExists(FILE_PATH);
            taskManager = new TaskManager(storage.fileLoad());
            Ui.printLoadSuccessMessage();
        } catch (IOException e) {
            Ui.printLoadErrorMessage();
        }
        Ui.greet();
    }

    public void run() {
        boolean isExit= false;
        Parser parser = new Parser();

        do {
            String line = ui.readCommand();
            try {
                Command command = parser.parseCommand(line);
                command.executeCommand(taskManager, ui, storage);
                isExit= command.isExit();
            } catch (InvalidCommandException e) {
                Ui.printInvalidCommandMessage();
            }  catch (InvalidIndexException e) {
                Ui.printErrorNoNumMessage();
            } catch (InvalidArgumentException e){
                Ui.printErrorNoDescriptionMessage();
            } catch (NullPointerException e){
            }
        } while (!isExit);
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}

