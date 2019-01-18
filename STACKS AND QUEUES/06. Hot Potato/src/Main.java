import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> childrenQueue = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));
        int n = scanner.nextInt();
        while(childrenQueue.size() > 1){
            for (int i = 0; i < n; i++) {
                String children = childrenQueue.poll();
                childrenQueue.offer(children);
            }
            System.out.println("Removed " + childrenQueue.pollLast());
        }
        System.out.println("Last is " + childrenQueue.poll());
    }
}
