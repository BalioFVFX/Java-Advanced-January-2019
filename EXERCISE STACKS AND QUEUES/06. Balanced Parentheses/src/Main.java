import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        char[] openingParenthesis = {'(', '{', '['};
        char[] closingParenthesis = {')', '}', ']'};

        int length = 0;
        ArrayDeque<Character> things = new ArrayDeque<>();

        if (input.length() % 2 == 0) {
            length = input.length() / 2;
            length += 1;
        } else {
            length = (int) Math.ceil((double) input.length() / 2);
        }

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == ' ') {
                continue;
            }
            if (!contains(current, closingParenthesis)) {

                try {
                    char end = closingParenthesis[getPosition(current, openingParenthesis)];
                    if (input.charAt(input.length() - 1 - i) != end) {
                        boolean isValid = false;
                        for (int j = i; j < input.length(); j++) {
                            if (input.charAt(j) == end) {
                                isValid = true;
                                break;
                            }
                        }
                        if (isValid == false) {
                            System.out.println("NO");
                            return;
                        }

                    }
                } catch (Exception e) {
                    System.out.println("NO");
                    return;
                }
                things.offer(current);
            } else {
                char start = openingParenthesis[getPosition(current, closingParenthesis)];
                if (things.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                else if(start != things.pollLast()){
                    System.out.println("NO");
                    return;
                }
            }


        }
        System.out.println("YES");

    }

    private static boolean contains(char symbol, char[] closingParenthesis) {
        for (int i = 0; i < closingParenthesis.length; i++) {
            if (closingParenthesis[i] == symbol) {
                return true;
            }
        }
        return false;
    }

    private static int getPosition(char symbol, char[] openingParenthesis) {
        for (int i = 0; i < openingParenthesis.length; i++) {
            if (openingParenthesis[i] == symbol) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }
}
