package ua.org.dmitrychernykh.SkiPassSystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Class for saving data
 *
 * @author Dmitry Chernykh on 26.04.2015.
 *         project Labs for EPAM courses
 */
public class LoadSaveData {
    private static final String CATALOG = "C:\\Users\\Alice\\IdeaProjects\\Labs\\Lab_8\\data\\";
    private static final String START_DATA_FILE = CATALOG + "input.txt";
    private static final String ACTUAL_DATA_FILE = CATALOG + "actualdata.txt";

    public static void saveData() {
        File file = new File(ACTUAL_DATA_FILE);
        String content = "This is the text content";

        try (FileOutputStream fop = new FileOutputStream(file)) {

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToFile(LinkedList data, String name) {
        File file = new File(CATALOG + name + ".txt");

        try (FileOutputStream fop = new FileOutputStream(file)) {

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            for (Object note : data) {
                fop.write(note.toString().getBytes());
                fop.write("\n".getBytes());
            }
            fop.flush();
            fop.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadData() {

    }
}
