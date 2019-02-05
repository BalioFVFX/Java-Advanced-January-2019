import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCars = Integer.parseInt(bufferedReader.readLine());
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] lines = bufferedReader.readLine().split("\\s+");
            String model = lines[0];
            double fuelAmount = Double.parseDouble(lines[1]);
            double fuelCost = Double.parseDouble(lines[2]);
            Car car = new Car(model, fuelAmount, fuelCost);
            cars.put(model, car);
        }

        String input = bufferedReader.readLine();

        while (!input.equals("End")) {
            String[] lines = input.split("\\s+");
            String model = lines[1];
            double distance = Double.parseDouble(lines[2]);
            Car car = cars.get(model);
            car.drive(distance);

            input = bufferedReader.readLine();
        }

        cars.values().forEach(System.out::println);
    }
}
