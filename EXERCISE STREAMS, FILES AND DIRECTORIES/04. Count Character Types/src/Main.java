import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String FILE_PATH = "C:\\Users\\Erik\\Desktop\\Exercises\\Exercises Resources\\input.txt";

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        List<Character> punctuations = Arrays.asList('!', ',', '.', '?');
        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationCount = 0;

        int byteData = fileInputStream.read();

        while (byteData >= 0) {
            if ((char) byteData == ' ' || (char) byteData == '\n' || (char) byteData == '\r') {
                byteData = fileInputStream.read();
                continue;
            }

            if (vowels.contains((char) byteData)) {
                vowelsCount++;
            } else if (punctuations.contains((char) byteData)) {
                punctuationCount++;
            } else {
                consonantsCount++;
            }

            byteData = fileInputStream.read();
        }

        System.out.println(String.format("Vowels: %s", vowelsCount));
        System.out.println(String.format("Consonants: %s", consonantsCount));
        System.out.println(String.format("Punctuation: %s", punctuationCount));
    }
}
