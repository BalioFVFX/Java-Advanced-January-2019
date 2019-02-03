import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private static final Function<List<Integer>, Integer> findSmallestInCollection = numbers -> {

        Integer smallestNumber = Integer.MAX_VALUE;
        Integer position = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) <= smallestNumber) {
                position = i;
                smallestNumber = numbers.get(i);
            }
        }
        return position;
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(bufferedReader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Integer smallestNumberIndex = findSmallestInCollection.apply(numbers);
        System.out.println(smallestNumberIndex);
    }
}
