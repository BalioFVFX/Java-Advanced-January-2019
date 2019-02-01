import java.io.*;

public class Main {
    private final static String OBJECT_PATH = "C:\\Users\\Erik\\Desktop\\Lab\\cube.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube = new Cube("green", 15.3, 12.4, 3.0);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(OBJECT_PATH));
        objectOutputStream.writeObject(cube);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(OBJECT_PATH));

        Cube myRestoredCube = (Cube) objectInputStream.readObject();

        System.out.println(myRestoredCube.getColor());
        System.out.println(myRestoredCube.getWidth());
        System.out.println(myRestoredCube.getHeight());
        System.out.println(myRestoredCube.getDepth());
    }
}
