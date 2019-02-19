import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).sorted().toArray();
        int searchedNumber = Integer.parseInt(bufferedReader.readLine());

        int index = numbers.length / 2;

        while (true) {
            try {
                if (searchedNumber > numbers[index]) {
                    index++;
                } else if (searchedNumber < numbers[index]) {
                    index--;
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(index);
    }
}
