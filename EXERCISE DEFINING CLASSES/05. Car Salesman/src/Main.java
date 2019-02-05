import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfEngines = Integer.parseInt(bufferedReader.readLine());
        LinkedHashMap<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfEngines; i++) {
            String[] lines = bufferedReader.readLine().split("\\s+");
            Engine engine = null;
            String model = lines[0];
            int power = Integer.parseInt(lines[1]);

            if (lines.length == 2) {
                engines.put(model, new Engine(model, power));
                continue;
            } else if (lines.length == 3) {
                try {
                    int displacement = Integer.parseInt(lines[2]);
                    engines.put(model, new Engine(model, power, displacement));
                } catch (NumberFormatException e) {
                    String color = lines[2];
                    engines.put(model, new Engine(model, power, color));
                }
            } else if (lines.length == 4) {
                int displacement = Integer.parseInt(lines[2]);
                String color = lines[3];
                engines.put(model, new Engine(model, power, displacement, color));
            }
        }
        int numberOfCars = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < numberOfCars; i++) {
            String[] lines = bufferedReader.readLine().split("\\s+");

            String make = lines[0];
            String engineName = lines[1];
            Engine engine = engines.get(engineName);

            if (lines.length == 2) {
                Car car = new Car(make, engine);
                cars.add(car);
            } else if (lines.length == 3) {
                Car car = null;
                try {
                    int weight = Integer.parseInt(lines[2]);
                    car = new Car(make, engine, weight);
                } catch (NumberFormatException e) {
                    String color = lines[2];
                    car = new Car(make, engine, color);
                }
                cars.add(car);
            } else if (lines.length == 4) {
                int weight = Integer.parseInt(lines[2]);
                String color = lines[3];
                Car car = new Car(make, engine, weight, color);
                cars.add(car);
            }
        }

        cars.forEach(System.out::println);
    }
}
