package Command;

import Storage.Storage;
import Ui.Ui;
import TaskManager.TaskManager;

public abstract class Command {

    public abstract void executeCommand(TaskManager taskManager, Ui ui, Storage storage);
    public boolean isExit(){
        return false;
    }
}