import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

    private final static String DIRECTORY_PATH = "C:\\Users\\Erik\\Desktop\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
    private static int count = 0;
    public static void main(String[] args) throws IOException {

        File folder = new File(DIRECTORY_PATH);

        File[] files = folder.listFiles();

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.addFirst(folder);
        int folderCount = 0;
        while (!queue.isEmpty()){
            File currentFile = queue.poll();

            if(currentFile.isDirectory()){
                System.out.println(currentFile.getName());
                queue.addAll(Arrays.asList(currentFile.listFiles()));
                folderCount++;
            }
        }

        System.out.printf("%s folders", folderCount);
    }
}
