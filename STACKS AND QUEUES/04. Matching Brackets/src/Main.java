import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> openingBracketIndexes = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if(currentChar == '('){
                openingBracketIndexes.push(i);
            }
            if(currentChar == ')'){
                Integer startIndex = openingBracketIndexes.pop();
                Integer endIndex = i + 1;
                printExpression(input, startIndex, endIndex);
            }
        }
    }

    private static void printExpression(String input, Integer start, Integer end){
        System.out.println(input.substring(start, end));
    }
}
