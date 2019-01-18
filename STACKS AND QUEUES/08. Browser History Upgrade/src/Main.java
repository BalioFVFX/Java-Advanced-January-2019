import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private final static String FORWARD_COMMAND = "forward";
    private final static String BACK_COMMAND = "back";
    private final static String END_COMMAND = "Home";
    private final static String NO_NEXT = "no next URLs";
    private final static String NO_BACK = "no previous URLs";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> browserForwardHistory = new ArrayDeque<>();
        String command = scanner.nextLine();
        while (!command.equals(END_COMMAND)){

            if(command.equals(FORWARD_COMMAND)){
                if(browserForwardHistory.isEmpty()){
                    System.out.println(NO_NEXT);
                    command = scanner.nextLine();
                    continue;
                }
                else{
                    String forwardUrl = browserForwardHistory.poll();
                    browserHistory.push(forwardUrl);
                    System.out.println(forwardUrl);
                    command = scanner.nextLine();
                    continue;
                }
            }

            else if(command.equals(BACK_COMMAND)){
                if(browserHistory.size() < 2){
                    System.out.println(NO_BACK);
                    command = scanner.nextLine();
                    continue;
                }
                else{
                    String currentUrl = browserHistory.pop();
                    String previousUrl = browserHistory.pop();
                    browserHistory.push(previousUrl);
                    browserForwardHistory.push(currentUrl);
                    System.out.println(previousUrl);
                    command = scanner.nextLine();
                    continue;
                }
            }
            System.out.println(command);
            browserHistory.push(command);
            browserForwardHistory.clear();
            command = scanner.nextLine();
        }
    }
}
