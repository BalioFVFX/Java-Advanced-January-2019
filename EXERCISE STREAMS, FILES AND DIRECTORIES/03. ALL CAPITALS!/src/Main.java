import java.io.*;

public class Main {
    private static final String FILE_PATH = "C:\\Users\\Erik\\Desktop\\Exercises\\Exercises Resources\\input.txt";
    private static final String FILE_OUTPUT = "C:\\Users\\Erik\\Desktop\\Exercises\\Exercises Resources\\output03.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
        FileWriter fileWriter = new FileWriter(FILE_OUTPUT);

        String line = bufferedReader.readLine();

        while (line != null){
            fileWriter.write(line.toUpperCase() + "\n");

            line = bufferedReader.readLine();
        }
        fileWriter.flush();
    }
}
