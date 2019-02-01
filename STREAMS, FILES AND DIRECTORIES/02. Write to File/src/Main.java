import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private final static String FILE_PATH = "C:\\Users\\Erik\\Desktop\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    private final static String FILE_OUTPUT_PATH = "C:\\Users\\Erik\\Desktop\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";


    public static void main(String[] args) {

        List<Character> SKIP_SYMBOLS = Arrays.asList(',', '.', '!', '?');

        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_OUTPUT_PATH);

            int currentByte = fileInputStream.read();

            while (currentByte >= 0){

                if(!SKIP_SYMBOLS.contains((char)currentByte)){
                    fileOutputStream.write((char)currentByte);
                }

                currentByte = fileInputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
