import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCars = Integer.parseInt(bufferedReader.readLine());

        LinkedHashMap<String, List<Car>> cargoTypes = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] lines = bufferedReader.readLine().split("\\s+");

            String model = lines[0];

            int engineSpeed = Integer.parseInt(lines[1]);
            int enginePower = Integer.parseInt(lines[2]);

            int cargoWeight = Integer.parseInt(lines[3]);
            String cargoType = lines[4];

            double tirePressure1 = Double.parseDouble(lines[5]);
            int tireAge1 = Integer.parseInt(lines[6]);

            double tirePressure2 = Double.parseDouble(lines[7]);
            int tireAge2 = Integer.parseInt(lines[8]);

            double tirePressure3 = Double.parseDouble(lines[9]);
            int tireAge3 = Integer.parseInt(lines[10]);

            double tirePressure4 = Double.parseDouble(lines[11]);
            int tireAge4 = Integer.parseInt(lines[12]);

            Tire[] tires = new Tire[4];
            tires[0] = new Tire(tireAge1, tirePressure1);
            tires[1] = new Tire(tireAge2, tirePressure2);
            tires[2] = new Tire(tireAge3, tirePressure3);
            tires[3] = new Tire(tireAge4, tirePressure4);

            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Engine engine = new Engine(engineSpeed, enginePower);

            Car car = new Car(model, engine, cargo, tires);

            if (!cargoTypes.containsKey(cargoType)) {
                List<Car> cars = new ArrayList<>();
                cars.add(car);
                cargoTypes.put(cargoType, cars);
            } else {
                List<Car> cars = cargoTypes.get(cargoType);
                cars.add(car);
                cargoTypes.put(cargoType, cars);
            }
        }
        String cargoType = bufferedReader.readLine();
        if (cargoType.equals("fragile")) {
            cargoTypes.get(cargoType).stream().filter(car -> {
                boolean hasGoodTires = false;
                for (int i = 0; i < car.getTires().length; i++) {
                    if (car.getTires()[i].getPressure() <= 1) {
                        return true;
                    }
                }
                return false;
            })
                    .forEach(car -> System.out.printf("%s%n", car.getModel()));
        } else if (cargoType.equals("flamable")) {
            cargoTypes.get(cargoType).stream().filter(car -> car.getEngine().getPower() > 250)
                    .forEach(car -> System.out.printf("%s%n", car.getModel()));
        }

    }
}
