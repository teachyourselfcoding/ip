package Command;

import Storage.Storage;
import Ui.Ui;
import TaskManager.TaskManager;


public class SaveCommand extends Command{
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage Storage) {
        Storage.saveToFile(taskManager.getTasks());
    }
}
