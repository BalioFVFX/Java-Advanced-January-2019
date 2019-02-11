import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Box<Double> box = new Box<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            box.getCollection().add(Double.parseDouble(bufferedReader.readLine()));
        }

        double element = Double.parseDouble(bufferedReader.readLine());

        int countOfGreaterElements = Box.compare(box.getCollection(), element);

        System.out.println(countOfGreaterElements);
    }
}