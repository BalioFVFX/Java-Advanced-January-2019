import java.io.*;

public class Main {
    private static final String FILE_PATH = "C:\\Users\\Erik\\Desktop\\Exercises\\Exercises Resources\\input.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));

        String line = bufferedReader.readLine();

        while (line != null) {
            System.out.println(getLineSum(line));

            line = bufferedReader.readLine();
        }
    }

    private static Integer getLineSum(String txt) {
        Integer sum = 0;
        for (int i = 0; i < txt.length(); i++) {
            sum += txt.charAt(i);
        }
        return sum;
    }
}
