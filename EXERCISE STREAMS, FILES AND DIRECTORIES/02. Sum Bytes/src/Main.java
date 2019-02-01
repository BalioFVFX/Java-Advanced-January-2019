import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String FILE_PATH = "C:\\Users\\Erik\\Desktop\\Exercises\\Exercises Resources\\input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
        String line = bufferedReader.readLine();

        Long sum = 0L;
        while (line != null) {
            sum += getLineSum(line);

            line = bufferedReader.readLine();
        }

        System.out.println(sum);
    }

    private static Long getLineSum(String txt) {

        Long sum = 0L;

        for (int i = 0; i < txt.length(); i++) {
            sum += txt.charAt(i);
        }

        return sum;
    }

}
