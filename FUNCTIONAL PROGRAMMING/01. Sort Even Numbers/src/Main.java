import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<Integer> filterEvenNumbers = number -> number % 2 == 0;

        int[] numbers = Arrays.stream(bufferedReader.readLine().split(", ")).mapToInt(Integer::parseInt).filter(filterEvenNumbers::test).toArray();

        System.out.println(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(numbers).sorted().mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    }
}
