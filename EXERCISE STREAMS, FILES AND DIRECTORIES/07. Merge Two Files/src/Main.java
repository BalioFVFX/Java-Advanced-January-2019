import java.io.*;

public class Main {
    private static final String FILE_PATH_01 = "C:\\Users\\Erik\\Desktop\\Exercises\\Exercises Resources\\inputOne.txt";
    private static final String FILE_PATH_02 = "C:\\Users\\Erik\\Desktop\\Exercises\\Exercises Resources\\inputTwo.txt";
    private static final String FILE_PATH_OUTPUT = "C:\\Users\\Erik\\Desktop\\Exercises\\Exercises Resources\\output07.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH_01));
        PrintWriter printWriter = new PrintWriter(new FileWriter(FILE_PATH_OUTPUT));

        StringBuilder resultTxt = new StringBuilder();

        resultTxt.append(getText(bufferedReader));

        bufferedReader = new BufferedReader(new FileReader(FILE_PATH_02));

        resultTxt.append(getText(bufferedReader));

        printWriter.print(resultTxt.toString());

        printWriter.flush();

    }

    private static String getText(BufferedReader bufferedReader) throws IOException {
        String line = bufferedReader.readLine();

        StringBuilder builder = new StringBuilder();
        while (line != null) {
            builder.append(line).append("\n");
            line = bufferedReader.readLine();
        }
        return builder.toString();
    }
}
