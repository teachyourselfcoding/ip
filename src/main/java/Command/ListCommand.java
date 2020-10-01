package Command;

import Storage.Storage;
import Ui.Ui;
import TaskManager.TaskManager;


public class ListCommand extends Command{
    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage){
        taskManager.printList();
    }
}

