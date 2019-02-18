import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int result = sum(numbers, 0);
        System.out.println(result);
    }

    private static int sum(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }

        return arr[index] + sum(arr, index + 1);
    }
}
