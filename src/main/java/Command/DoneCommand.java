package Command;

import Storage.Storage;
import Ui.Ui;
import TaskManager.TaskManager;

public class DoneCommand extends Command {
    private final int index;

    public DoneCommand(String index)
    {
        int num = Integer.parseInt(index);
        this.index = num;
    }

    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) {
        taskManager.markDone(index);
    }
}
