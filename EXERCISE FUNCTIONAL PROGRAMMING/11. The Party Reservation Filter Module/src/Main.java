import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> guests = Arrays.stream(bufferedReader.readLine().split("\\s+")).collect(Collectors.toList());

        LinkedHashMap<String, List<String>> history = new LinkedHashMap<>();

        String line = bufferedReader.readLine();

        while (!line.equals("Print")) {
            String commandType = line.split("\\s+")[0];
            String[] commands = line.split(";");

            switch (commandType) {
                case "Add":
                    add(guests, history, commands);
                    break;
                case "Remove":
                    remove(history, commands);
                    break;
                default:
                    break;
            }

            line = bufferedReader.readLine();
        }

        for (List<String> historyGuests : history.values()) {
            for (String historyGuest : historyGuests) {
                guests.remove(historyGuest);
            }
        }
        guests.forEach(guest -> System.out.printf("%s ", guest));
    }

    private static void remove(LinkedHashMap<String, List<String>> history, String[] commands) {
        history.remove(commands[1] + commands[2]);
        System.out.println();
    }

    private static void add(List<String> guests, LinkedHashMap<String, List<String>> history, String[] commands) {
        List<String> historyGuests = new ArrayList<>();
        if (commands[1].equals("Starts with")) {
            historyGuests = guests.stream().filter(name -> name.startsWith(commands[2])).collect(Collectors.toList());
        } else if (commands[1].equals("Ends with")) {
            historyGuests = guests.stream().filter(name -> name.endsWith(commands[2])).collect(Collectors.toList());
        } else if (commands[1].equals("Length")) {
            historyGuests = guests.stream().filter(name -> name.length() == Integer.parseInt(commands[2])).collect(Collectors.toList());
        } else if (commands[1].equals("Contains")) {
            historyGuests = guests.stream().filter(name -> name.contains(commands[2])).collect(Collectors.toList());
        }

        if (!history.containsKey(commands[0] + commands[1])) {
            history.put(commands[1] + commands[2], historyGuests);
        } else {
            List<String> oldHistoryGuests = history.get(commands[1] + commands[2]);
            historyGuests.addAll(historyGuests);
            history.put(commands[1] + commands[2], oldHistoryGuests);
        }

    }


}
