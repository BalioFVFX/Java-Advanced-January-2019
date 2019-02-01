import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    private final static String DIRECTORY_PATH = "C:\\Users\\Erik\\Desktop\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

    public static void main(String[] args) throws IOException {
        Files.list(Paths.get(DIRECTORY_PATH)).forEach(f -> {
            File file = f.toFile();
            if (file.isFile()) {
                System.out.println(String.format("%s: [%s]", file.getName(), file.length()));
            }
        });
    }
}
