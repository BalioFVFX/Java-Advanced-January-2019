import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        reverse(numbers, 0, numbers.length);

        Arrays.stream(numbers).forEach(number -> System.out.printf("%s ", number));
    }

    private static void reverse(int[] numbers, int start, int end) {
        if (end == numbers.length / 2) {
            return;
        }

        int tempStart = numbers[start];
        int tempEnd = numbers[end - 1];
        numbers[start] = tempEnd;
        numbers[end - 1] = tempStart;
        reverse(numbers, start + 1, end - 1);
        return;


    }
}
