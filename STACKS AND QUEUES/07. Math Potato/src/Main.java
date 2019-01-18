import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] childs = scanner.nextLine().split("\\s+");
        ArrayDeque<String> childQueue = new ArrayDeque<>();
        Collections.addAll(childQueue, childs);

        Integer n = scanner.nextInt();
        Integer cycle = 1;
        while(childQueue.size() > 1){
            for (int i = 0; i < n - 1; i++) {
                String child = childQueue.poll();
                childQueue.offer(child);
            }
            if(isPrimeNumber(cycle)){
                System.out.println("Prime " + childQueue.peek());
            }
            else{
                System.out.println("Removed " + childQueue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + childQueue.poll());
    }

    private static boolean isPrimeNumber(Integer number){
        if(number == 1){
            return false;
        }
        for (int i = 2; i < number; i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
