import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {

    private static final String FILE_PATH = "C:\\Users\\Erik\\Desktop\\Exercises\\Exercises Resources\\words.txt";
    private static final String TXT_FILE_PATH = "C:\\Users\\Erik\\Desktop\\Exercises\\Exercises Resources\\text.txt";
    private static final String OUTPUT_PATH = "C:\\Users\\Erik\\Desktop\\Exercises\\Exercises Resources\\results.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
        PrintWriter printWriter = new PrintWriter(OUTPUT_PATH);

        List<String> searchedWords = Arrays.asList(bufferedReader.readLine().split("\\s+"));

        LinkedHashMap<String, Long> words = new LinkedHashMap<>();

        bufferedReader = new BufferedReader(new FileReader(TXT_FILE_PATH));
        String line = bufferedReader.readLine();

        while (line != null) {
            String[] currentWords = line.split("\\s+");

            for (int i = 0; i < currentWords.length; i++) {
                String currentWord = currentWords[i];

                if (searchedWords.contains(currentWord)) {
                    if (!words.containsKey(currentWord)) {
                        words.put(currentWord, 1L);
                    } else {
                        words.put(currentWord, words.get(currentWord) + 1);
                    }
                }
            }
            line = bufferedReader.readLine();
        }
        words.entrySet().stream().sorted((frequency1, frequency2) -> {
            return frequency2.getValue().compareTo(frequency1.getValue());
        }).forEach(entry -> {
            printWriter.println(String.format("%s - %s", entry.getKey(), entry.getValue()));
        });

        printWriter.flush();
    }
}
