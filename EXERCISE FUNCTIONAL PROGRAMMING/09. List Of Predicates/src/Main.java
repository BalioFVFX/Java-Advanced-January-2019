import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final BiPredicate<Integer, List<Integer>> divisiblePredicate = (number, sequence) -> {
        for (int i = 0; i < sequence.size(); i++) {
            if (number % sequence.get(i) != 0) {
                return false;
            }
        }
        return true;
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(bufferedReader.readLine());
        List<Integer> sequence = Arrays.stream(bufferedReader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        IntStream.range(1, n + 1).filter(number -> divisiblePredicate.test(number, sequence)).forEach(number -> {
            System.out.printf("%s ", number);
        });
    }
}
