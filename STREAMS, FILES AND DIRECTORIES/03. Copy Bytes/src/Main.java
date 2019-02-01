import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    private final static String FILE_PATH = "C:\\Users\\Erik\\Desktop\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    private final static String FILE_OUTPUT_PATH = "C:\\Users\\Erik\\Desktop\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_OUTPUT_PATH);

            int currentByte = fileInputStream.read();

            while (currentByte >= 0) {
                if(currentByte == ' ' || currentByte == '\n'){
                    fileOutputStream.write(currentByte);
                    currentByte = fileInputStream.read();
                    continue;
                }
                String currentStr = String.valueOf(currentByte);

                for (int i = 0; i < currentStr.length(); i++) {
                    fileOutputStream.write(currentStr.charAt(i));
                }

                currentByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
