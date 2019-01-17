import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    private final static String END_COMMAND = "print";
    private final static String CANCEL_COMMAND = "cancel";
    private final static String STANDBY = "Printer is on standby";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> filesQueue = new ArrayDeque<>();
        while(!input.equals(END_COMMAND)){
            if(input.equals(CANCEL_COMMAND)){
                String canceledFile = filesQueue.pollFirst();
                if(canceledFile != null) {
                    System.out.println(String.format("Canceled %s", canceledFile));
                }
                if(filesQueue.isEmpty() && canceledFile == null){
                    System.out.println(STANDBY);
                }
                input = scanner.nextLine();
                continue;
            }
            filesQueue.offer(input);
            input = scanner.nextLine();
        }

        while(!filesQueue.isEmpty()){
            System.out.println(filesQueue.pollFirst());
        }
    }
}
