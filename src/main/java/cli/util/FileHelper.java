package cli.util;

import java.io.File;

public class FileHelper {

    public static final String ROOT = "/home/amakogon/";
    private static String currentDirectory = ROOT;

    public static String getCurrentDirectory() {
        return currentDirectory;
    }

    public static void displayListOfFiles(String directory) {
        File dir = new File(directory);
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file.getPath());
        }
    }

    public static void changeDirectory(String directory) {
        File dir = new File(directory);
        File curDir = new File(currentDirectory);
        if(dir.exists()){
            currentDirectory = directory;
        }
    }
}
