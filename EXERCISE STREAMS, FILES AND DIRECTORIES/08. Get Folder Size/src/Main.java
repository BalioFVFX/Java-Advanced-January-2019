import java.io.File;

public class Main {
    private static final String DIRECTORY_PATH = "C:\\Users\\Erik\\Desktop\\Exercises\\Exercises Resources\\Exercises Resources";

    public static void main(String[] args) {
        File[] files = new File(DIRECTORY_PATH).listFiles();
        Long totalSize = 0L;

        for (File file : files) {
            if (file.isFile()) {
                totalSize += file.length();
            }
        }

        System.out.println(String.format("Folder size: %s", totalSize));
    }
}
