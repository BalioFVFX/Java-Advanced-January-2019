import java.io.*;


public class Main {
    private static final String PICTURE_LOCATION = "C:\\Users\\Erik\\Desktop\\Original Location\\example.jpg";
    private static final String DESTINATION_LOCATION = "C:\\Users\\Erik\\Desktop\\Destination\\picture-copy.jpg";

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(PICTURE_LOCATION);

        byte[] bytes = fileInputStream.readAllBytes();

        FileOutputStream fileOutputStream = new FileOutputStream(DESTINATION_LOCATION);

        fileOutputStream.write(bytes);
    }
}
