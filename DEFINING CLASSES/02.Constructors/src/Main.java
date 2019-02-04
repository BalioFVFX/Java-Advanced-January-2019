import model.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int carsCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < carsCount; i++) {
            String[] lines = bufferedReader.readLine().split("\\s+");

            Car car = null;

            if (lines.length == 3) {
                car = new Car(lines[0], lines[1], Integer.parseInt(lines[2]));
            } else {
                car = new Car(lines[0]);
            }
            System.out.println(car);
        }
    }
}
