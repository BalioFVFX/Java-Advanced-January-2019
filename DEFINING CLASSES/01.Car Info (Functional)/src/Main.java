import model.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer count = Integer.parseInt(bufferedReader.readLine());

        IntStream.rangeClosed(1, count)
                .boxed()
                .map(input -> {
                    try {
                        return bufferedReader.readLine().split("\\s+");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .map(input -> new Car(input[0], input[1], Integer.parseInt(input[2])))
                .forEach(System.out::println);
    }
}