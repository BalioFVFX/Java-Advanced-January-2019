import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] commands = Arrays.stream(scanner.nextLine().split("\\s")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] numbersToFill = Arrays.stream(scanner.nextLine().split("\\s")).map(Integer::parseInt).toArray(Integer[]::new);

        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();

        fillQueue(commands[0], numbersToFill, numbersQueue);
        removeElementsFromQueue(commands[1], numbersQueue);
        findNumber(commands[2], numbersQueue);
    }

    private static void fillQueue(Integer count, Integer[] numbers, ArrayDeque<Integer> queue) {
        for (int i = 0; i < count; i++) {
            queue.offer(numbers[i]);
        }
    }

    private static void removeElementsFromQueue(Integer count, ArrayDeque<Integer> queue) {
        for (int i = 0; i < count; i++) {
            queue.poll();
        }
    }

    private static void findNumber(Integer searchedNumber, ArrayDeque<Integer> queue) {
        if (queue.isEmpty()) {
            System.out.println(0);
            return;
        }
        
        Iterator<Integer> numbersIterator = queue.iterator();
        Integer smallestNumber = Integer.MAX_VALUE;

        while (numbersIterator.hasNext()) {
            Integer currentNumber = numbersIterator.next();

            if (searchedNumber.equals(currentNumber)) {
                System.out.println("true");
                return;
            }

            if (currentNumber < smallestNumber) {
                smallestNumber = currentNumber;
            }
        }
        System.out.println(smallestNumber);
    }
}
