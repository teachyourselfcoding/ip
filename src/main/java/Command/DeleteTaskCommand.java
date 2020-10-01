package Command;


import Storage.Storage;
import TaskManager.TaskManager;
import Ui.Ui;

public class DeleteTaskCommand extends Command{
    private final String index;

    public DeleteTaskCommand(String index){
        this.index = index;
    }

    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) {
        int num = Integer.parseInt(index);
        TaskManager.Delete(num);
    }
}