import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numberStackElements = new ArrayDeque<>();
        int nCommands =Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < nCommands; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            commandExecutor(commands, numberStackElements);
        }
    }

    private static void commandExecutor(String[] commands, ArrayDeque<Integer> stack) {
        switch (commands[0]) {
            case "1":
                stack.push(Integer.parseInt(commands[1]));
                break;
            case "2":
                stack.pop();
                break;
            case "3":
                System.out.println(findMaxInStack(stack));
                break;
            default:
                break;
        }
    }

    private static int findMaxInStack(ArrayDeque<Integer> stack){
        int maxNum = Integer.MIN_VALUE;
        Iterator<Integer> stackIterator = stack.iterator();
        while (stackIterator.hasNext()){
            int currentNum = stackIterator.next();
            if(currentNum > maxNum){
                maxNum = currentNum;
            }
        }
        return maxNum;
    }
}
