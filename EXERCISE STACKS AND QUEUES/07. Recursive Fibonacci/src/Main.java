import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Main {
    private static HashMap<Long, Long> cache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(getFibonacciMemo(Long.parseLong(bufferedReader.readLine())));
    }


    private static Long getFibonacciMemo(Long n) {
        Long fibonacci = cache.get(n);

        if (n < 2) {
            return 1L;
        } else {
            if (fibonacci != null) {
                return cache.get(n);
            } else {
                fibonacci = getFibonacciMemo(n - 1) + getFibonacciMemo(n - 2);
                cache.put(n, fibonacci);
            }
        }
        return fibonacci;
    }
}
