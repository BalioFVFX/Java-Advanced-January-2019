import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> numbersStr = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));
        Double result = Double.parseDouble(numbersStr.pop());

        while (!numbersStr.isEmpty()){
            String symbol = numbersStr.pop();
            Double number = Double.parseDouble(numbersStr.pop());
            result = calculate(symbol, result, number);
        }
        System.out.printf("%.0f", result);
    }

    private static Double calculate(String symbol, Double result, Double number){
        switch (symbol){
            case "+":
                return result + number;
            case "-":
                return result - number;
            case "/":
                return result / number;
            case "*":
                return result * number;
                default:
                    return null;
        }
    }
}
