import java.io.*;

public class Main {
    private final static String FILE_PATH = "C:\\Users\\Erik\\Desktop\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    private final static String FILE_OUTPUT_PATH = "C:\\Users\\Erik\\Desktop\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

    public static void main(String[] args) throws IOException {
        int lineNumber = 1;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
        PrintWriter printWriter = new PrintWriter(FILE_OUTPUT_PATH);

        String lineTxt = bufferedReader.readLine();
        while (lineTxt != null) {
            if (lineNumber % 3 == 0) {
                printWriter.println(lineTxt);
            }

            lineTxt = bufferedReader.readLine();
            lineNumber++;
        }
        printWriter.flush();
    }
}
