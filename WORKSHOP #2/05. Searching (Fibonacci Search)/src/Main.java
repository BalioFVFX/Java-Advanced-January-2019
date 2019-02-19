import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).sorted().toArray();

        int searchedNumber = Integer.parseInt(bufferedReader.readLine());

        int index = find(numbers, searchedNumber);

        System.out.println(index);
    }

    private static int find(int[] numbers, int searchedNumber) {
        int current = 1;
        int previous = 1;

        if (numbers[0] == searchedNumber) {
            return 0;
        }

        while (current < numbers.length && numbers[current] < searchedNumber) {

            if (numbers[current] == searchedNumber) {
                return current;
            }

            current = previous + current;
            previous = current - previous;
        }


        current = numbers.length - 1;


        for (int i = current; i >= previous; i--) {
            if (numbers[i] == searchedNumber) {
                return i;
            }
        }
        return -1;
    }
}
