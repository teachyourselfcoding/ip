package Command;

import Storage.Storage;
import TaskManager.TaskManager;
import Ui.Ui;

import java.io.IOException;

public class ByeCommand extends Command {
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) {

        ui.bidGoodbye();
        storage.saveToFile(taskManager.getTasks());
    }

    @Override
    public boolean isExit(){
        return true;
    }
}
