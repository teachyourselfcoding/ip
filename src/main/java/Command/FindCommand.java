package Command;

import Storage.Storage;
import TaskManager.TaskManager;
import Ui.Ui;

import java.io.IOException;

public class FindCommand extends Command{
    private final String description;

    public FindCommand(String description)
    {
        this.description = description;

    }

    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage) {
        TaskManager.Find(description);
    }
}

