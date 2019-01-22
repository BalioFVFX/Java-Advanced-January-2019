import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    private static ArrayDeque<Character> textQueue;
    private static ArrayDeque<String> commandsUndoQueue;
    private static ArrayDeque<String> commandsToProcess;

    public static void main(String[] args) throws IOException {
        textQueue = new ArrayDeque<>();
        commandsUndoQueue = new ArrayDeque<>();
        commandsToProcess = new ArrayDeque<>();

        getInput();

        String[] currentCommand = null;
        while (!commandsToProcess.isEmpty()) {
            currentCommand = commandsToProcess.poll().split("\\s+");
            switch (currentCommand[0]) {
                case "1":
                    commandsUndoQueue.offer(getTextBeforeUndo());
                    appendText(currentCommand[1]);
                    break;
                case "2":
                    commandsUndoQueue.offer(getTextBeforeUndo());
                    erase(Integer.parseInt(currentCommand[1]));
                    break;
                case "3":
                    char result = getElementAtIndex(Integer.parseInt(currentCommand[1]));
                    System.out.println(result);
                    break;
                case "4":
                    textQueue = new ArrayDeque<>(getLastText());
                    break;
                default:
                    break;
            }
        }
    }

    private static void getInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCommands = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String command = bufferedReader.readLine();
            commandsToProcess.offer(command);
        }
    }

    private static void appendText(String text) {
        for (int i = 0; i < text.length(); i++) {
            textQueue.offer(text.charAt(i));
        }
    }

    private static void erase(int count) {
        if (count > textQueue.size()) {
            return;
        }
        for (int i = 0; i < count; i++) {
            textQueue.pollLast();
        }
    }

    private static char getElementAtIndex(int index) {

        if (textQueue.isEmpty()) {
            return ' ';
        }

        ArrayDeque<Character> items = new ArrayDeque<>(textQueue);

        char result = ' ';

        for (int i = 0; i < index; i++) {
            result = items.poll();
        }

        return result;
    }


    private static String getTextBeforeUndo() {
        ArrayDeque<Character> chars = new ArrayDeque<>(textQueue);
        StringBuilder stringBuilder = new StringBuilder();
        while (!chars.isEmpty()) {
            stringBuilder.append(chars.poll());
        }
        return stringBuilder.toString();
    }

    private static ArrayDeque<Character> getLastText() {
        ArrayDeque<Character> result = new ArrayDeque<>();
        if (commandsUndoQueue.isEmpty()) {
            return result;
        }
        String latestText = commandsUndoQueue.pollLast();
        for (int i = 0; i < latestText.length(); i++) {
            result.offer(latestText.charAt(i));
        }
        return result;
    }

}
