import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Main {
    private final static String FILE_PATH = "C:\\Users\\Erik\\Desktop\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    private final static String FILE_OUTPUT_PATH = "C:\\Users\\Erik\\Desktop\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt";

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
        Collections.sort(lines);
        Files.write(Paths.get(FILE_OUTPUT_PATH), lines);
    }
}
