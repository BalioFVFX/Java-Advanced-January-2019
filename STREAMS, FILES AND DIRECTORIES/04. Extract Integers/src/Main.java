import java.io.*;
import java.util.Scanner;

public class Main {

    private final static String FILE_PATH = "C:\\Users\\Erik\\Desktop\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    private final static String FILE_OUTPUT_PATH = "C:\\Users\\Erik\\Desktop\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_PATH));
        FileWriter writer = new FileWriter(FILE_OUTPUT_PATH);
        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                int next = scanner.nextInt();
                System.out.println(next);
                writer.write(next + "\n");
            }
            scanner.next();
        }
        writer.flush();
    }
}
