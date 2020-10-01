package Command;

import Storage.Storage;
import TaskManager.TaskManager;
import Ui.Ui;

public class NewTaskCommand extends Command {
    private final String taskType;
    private final String taskDescription;

    public NewTaskCommand(String taskType, String taskDescription) {
        this.taskType = taskType;
        this.taskDescription = taskDescription;
    }

    @Override
    public void executeCommand(TaskManager taskManager, Ui ui, Storage storage){
        taskManager.addTask(taskType, taskDescription);
    }
}
