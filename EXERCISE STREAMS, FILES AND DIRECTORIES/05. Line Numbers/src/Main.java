import java.io.*;

public class Main {

    private static final String FILE_PATH = "C:\\Users\\Erik\\Desktop\\Exercises\\Exercises Resources\\inputLineNumbers.txt";
    private static final String OUTPUT_PATH = "C:\\Users\\Erik\\Desktop\\Exercises\\Exercises Resources\\output05.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
        PrintWriter printWriter = new PrintWriter(OUTPUT_PATH);

        String line = bufferedReader.readLine();

        int lineCounter = 1;

        while (line != null){
            String text = lineCounter + ". " + line;
            printWriter.println(text);
            lineCounter++;
            line = bufferedReader.readLine();
        }

        printWriter.flush();
    }
}
