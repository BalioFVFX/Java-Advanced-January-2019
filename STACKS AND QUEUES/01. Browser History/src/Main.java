import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    private final static String BACK_COMMAND = "back";
    private final static String END_COMMAND = "Home";
    private final static String INVALID_COMMAND = "no previous URLs";

    public static void main(String[] args) {
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        while (!line.equals(END_COMMAND)) {

            if (line.equals(BACK_COMMAND)) {
                if (browserHistory.size() > 1) {
                    browserHistory.pop();
                    String lastUrl = browserHistory.peek();
                    System.out.println(lastUrl);
                    line = scanner.nextLine();
                    continue;
                } else {
                    System.out.println(INVALID_COMMAND);
                    line = scanner.nextLine();
                    continue;
                }
            }

            browserHistory.push(line);
            System.out.println(line);
            line = scanner.nextLine();

        }
    }
}
