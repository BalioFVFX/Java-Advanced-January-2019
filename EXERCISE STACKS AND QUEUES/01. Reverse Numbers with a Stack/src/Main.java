import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        for (int i = 0; i < numbers.length; i++) {
            numbersStack.push(numbers[i]);
        }
        StringBuilder result = new StringBuilder();
        while (!numbersStack.isEmpty()){
            result.append(numbersStack.pop()).append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result.toString());
    }
}
