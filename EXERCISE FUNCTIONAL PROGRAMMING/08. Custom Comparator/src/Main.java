import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static final Comparator<Integer> sorter = (n1, n2) -> {
        if (n1 % 2 == 0 && n2 % 2 == 0) {
            return n1.compareTo(n2);
        }

        if (n1 % 2 != 0 && n2 % 2 != 0) {
            return n1.compareTo(n2);
        }

        if (n1 % 2 == 0 && n2 % 2 != 0) {
            return -1;
        }

        if (n1 % 2 != 0 && n2 % 2 == 0) {
            return 1;
        }

        return 0;
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Arrays.stream(bufferedReader.readLine().split("\\s+")).map(Integer::parseInt).sorted(sorter).forEach(n -> System.out.printf("%s ", n));
    }
}
