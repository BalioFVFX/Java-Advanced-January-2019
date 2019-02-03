import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Main {

    private final static BiPredicate<Long, Long> divider = (number, div) -> {
        return number % div != 0;
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Long> numbers = Arrays.stream(bufferedReader.readLine().split("\\s+")).map(Long::parseLong).collect(Collectors.toList());
        Long div = Long.parseLong(bufferedReader.readLine());
        numbers = numbers.stream().
                filter(number -> divider.test(number, div)).collect(Collectors.toList());

        Collections.reverse(numbers);

        numbers.forEach(n -> System.out.printf("%s ", n));
    }
}
