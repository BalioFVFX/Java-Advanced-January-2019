import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BiPredicate<String, Integer> types = (type, number) -> {
            if (type.equals("even")) {
                if (number % 2 == 0) {
                    return true;
                }
                return false;
            } else {
                if (number % 2 != 0) {
                    return true;
                }
                return false;
            }
        };

        int[] bounds = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String type = bufferedReader.readLine();
        IntStream.range(bounds[0], bounds[1] + 1).filter(number -> types.test(type, number)).forEach(number -> {
            System.out.print(number + " ");
        });
    }
}
