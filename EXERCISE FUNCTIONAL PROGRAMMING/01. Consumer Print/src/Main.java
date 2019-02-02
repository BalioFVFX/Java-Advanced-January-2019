import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) throws IOException {
        Consumer<String> printerNames = System.out::println;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Arrays.stream(bufferedReader.readLine().split("\\s+")).forEach(printerNames);
    }
}
