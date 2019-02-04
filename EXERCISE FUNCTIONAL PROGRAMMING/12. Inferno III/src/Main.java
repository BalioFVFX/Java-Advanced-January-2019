import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static LinkedHashMap<String, List<Integer>> historyIndexes;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> gems = Arrays.stream(bufferedReader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String line = bufferedReader.readLine();
        historyIndexes = new LinkedHashMap<>();

        while (!line.equals("Forge")) {
            String[] commands = line.split(";");
            String command = commands[0];
            String filterType = commands[1];
            Integer parameter = Integer.parseInt(commands[2]);

            switch (command) {
                case "Exclude":
                    exclude(gems, filterType, parameter);
                    break;
                case "Reverse":
                    reverse(filterType, parameter);
                    break;
            }

            line = bufferedReader.readLine();
        }

        for (List<Integer> indexes : historyIndexes.values()) {

            for (Integer number : indexes) {
                gems = gems.stream().filter(num -> !num.equals(number)).collect(Collectors.toList());
            }
        }

        gems.forEach(number -> System.out.printf("%s ", number));
    }

    private static void exclude(List<Integer> gems, String filterType, Integer parameter) {
        switch (filterType) {
            case "Sum Left":
                sumLeft(gems, parameter);
                break;
            case "Sum Right":
                sumRight(gems, parameter);
                break;
            case "Sum Left Right":
                sumLeftRight(gems, parameter);
                break;
        }
    }

    private static void sumLeftRight(List<Integer> gems, Integer parameter) {
        for (int i = 0; i < gems.size(); i++) {
            int leftNumber = getNumber(gems, i - 1);
            int currentNumber = getNumber(gems, i);
            int rightNumber = getNumber(gems, i + 1);

            if (leftNumber + currentNumber + rightNumber == parameter) {
                manageHistory("Sum Left Right", parameter, currentNumber);
            }
        }
    }

    private static void sumRight(List<Integer> gems, Integer parameter) {
        for (int i = 0; i < gems.size(); i++) {
            int rightNumber = getNumber(gems, i + 1);
            int currentNumber = getNumber(gems, i);
            if (currentNumber + rightNumber == parameter) {
                manageHistory("Sum Right", parameter, currentNumber);
            }
        }
    }

    private static Integer getNumber(List<Integer> gems, int index) {
        int number = 0;
        try {
            number = gems.get(index);
        } catch (IndexOutOfBoundsException e) {

        }
        return number;
    }

    private static void sumLeft(List<Integer> gems, Integer parameter) {
        for (int i = 0; i < gems.size(); i++) {
            int leftNumber = getNumber(gems, i - 1);
            int currentNumber = getNumber(gems, i);
            if (leftNumber + currentNumber == parameter) {
                manageHistory("Sum Left", parameter, currentNumber);
            }
        }
    }

    private static void reverse(String name, Integer parameter) {
        historyIndexes.remove(name + parameter);
    }

    private static void manageHistory(String name, Integer parameter, Integer index) {
        List<Integer> indexes = new ArrayList<>();
        if (!historyIndexes.containsKey(name + parameter)) {
            indexes.add(index);
            historyIndexes.put(name + parameter, indexes);
        } else {
            indexes = historyIndexes.get(name + parameter);
            indexes.add(index);
            historyIndexes.put(name + parameter, indexes);
        }
    }
}
