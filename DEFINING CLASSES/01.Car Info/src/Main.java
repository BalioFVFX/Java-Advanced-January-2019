import model.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer count = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < count; i++) {
            String[] carData = bufferedReader.readLine().split("\\s+");
            Car car = new Car(carData[0], carData[1], Integer.parseInt(carData[2]));
            System.out.println(car);
        }
    }
}
