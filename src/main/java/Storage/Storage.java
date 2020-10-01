package Storage;

//import duke.exception.FileFormatException;
import Task.Deadline;
import Task.Event;
import Task.Task;
import Task.ToDo;
import Ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final static String FILE_DIR = "data";
    private final static String FILE_PATH = "data/duke.txt";
    /***
     Create file directory
     ***/
    public Storage(String filePath){
            File fileDir = new File(FILE_DIR);
            FileWriter writer;

            if (!fileDir.exists()){
                fileDir.mkdir();
            }

            try {
                checkFileExists(filePath);
            } catch (IOException e){
                Ui.printLoadErrorMessage();
            }
    }

    /***
     Check if file exist at given path
     ***/
    public File checkFileExists(String filePath) throws IOException{
        File dataFile = new File(filePath);
        if (!dataFile.exists()){
            dataFile.createNewFile();
            Ui.printNewFileMessage();
        }
        return dataFile;
    }

    /***
     Load previous ArrayList from file
     ***/
    public ArrayList<Task> fileLoad() throws FileNotFoundException {
        ArrayList<Task> list = new ArrayList<>();

        File dataFile = new File(FILE_PATH);
        Scanner dataScanner = new Scanner(dataFile);

        while (dataScanner.hasNext()) {
            String data = dataScanner.nextLine();
            String info = data.substring(4);
            int infoIndex = (info.indexOf("|") + 2);
            int dateIndex = (info.substring(infoIndex)).indexOf("|") + infoIndex + 2;
            boolean done = info.substring(0, infoIndex - 3).equals("true");

            switch (data.substring(0, 1)) {
                case "D":
                    Task newDeadline = new Deadline(info.substring(infoIndex, dateIndex - 3), info.substring(dateIndex));
                    newDeadline.type = 'D';
                    newDeadline.isDone = done;
                    list.add(newDeadline);

                    break;
                case "T":
                    Task newTodo = new ToDo(info.substring(infoIndex,dateIndex - 3));
                    newTodo.type = 'T';
                    newTodo.isDone = done;
                    list.add(newTodo);

                    break;
                case "E":
                    Task newEvent = new Event(info.substring(infoIndex, dateIndex - 3), info.substring(dateIndex));
                    newEvent.type = 'D';
                    newEvent.isDone = done;
                    list.add(newEvent);
                    break;
                default:
                    break;
            }
        }
        return list;
    }

    /***
     Save ArrayList to file
     ***/
    public static void saveToFile(ArrayList<Task> list) {
        FileWriter writer;
        File fileDir = new File(FILE_DIR);

        if (!fileDir.exists()){
            fileDir.mkdir();
        }
        try {
            writer = new FileWriter(FILE_PATH);
            for (Task task : list) {
                writer.write(task.type + " | " + task.isDone + " | "
                        + task.description + " | " + task.date + System.lineSeparator());
            }
            writer.close();
            Ui.printSaveSuccessMessage();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}




