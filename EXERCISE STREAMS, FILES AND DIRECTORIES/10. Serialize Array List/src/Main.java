import java.io.*;
import java.util.ArrayList;

public class Main {
    private static final String DESTINATION = "C:\\Users\\Erik\\Desktop\\Destination\\list.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<String> strings = new ArrayList<>();

        strings.add("First item");
        strings.add("Second item");
        strings.add("Third item");


        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DESTINATION));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(DESTINATION));

        objectOutputStream.writeObject(strings);

        ArrayList<String> myReturnedArrayList = (ArrayList<String>) objectInputStream.readObject();

        for (String txt : myReturnedArrayList) {
            System.out.println(txt);
        }

    }
}
