import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        UnaryOperator<Double> vat = number -> number + (number * 0.20);

        System.out.println("Prices with VAT:");
        Arrays.stream(bufferedReader.readLine().split(", ")).mapToDouble(Double::parseDouble).forEach(number -> {
            System.out.printf("%.2f%n", vat.apply(number));
        });
    }
}
