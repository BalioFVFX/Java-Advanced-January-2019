import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] commands = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < commands[0]; i++) {
            numbersStack.push(numbers[i]);
        }

        for (int i = 0; i < commands[1]; i++) {
            numbersStack.pop();
        }

        if (numbersStack.isEmpty()) {
            System.out.println(0);
            return;
        }

        int searchNumber = commands[2];
        int smallestNum = Integer.MAX_VALUE;
        while (!numbersStack.isEmpty()) {
            int currentNum = numbersStack.pop();
            if (currentNum == searchNumber) {
                System.out.println("true");
                return;
            }
            if (currentNum < smallestNum) {
                smallestNum = currentNum;
            }
        }
        System.out.println(smallestNum);
    }
}
