import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        Function<String, Integer> getLength = txt -> {
            return txt.split(", ").length;
        };

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> {
            return a + b;
        };
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();

        System.out.println("Count = " + getLength.apply(input));

        int total = Arrays.stream(input.split(", ")).map(Integer::parseInt).reduce(sum::apply).orElse(0);

        System.out.println("Sum = " + total);

    }
}
