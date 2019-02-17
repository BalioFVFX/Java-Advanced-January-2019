import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCommands = Integer.parseInt(bufferedReader.readLine());
        numberOfCommands--;
        String[] header = bufferedReader.readLine().split(", ");
        int numberOfFields = header.length;
        List<List<String>> data = new ArrayList<>();

        for (int i = 0; i < numberOfCommands; i++) {
            List<String> fields = Arrays.stream(bufferedReader.readLine().split(", ")).collect(Collectors.toList());
            data.add(fields);
        }

        String[] commands = bufferedReader.readLine().split(" ");


        int indexPosition = 0;

        for (int i = 0; i < header.length; i++) {
            if (header[i].equals(commands[1])) {
                indexPosition = i;
                break;
            }
        }
        final int index = indexPosition;
        if (commands[0].equals("sort")) {
            List<List<String>> sorted = data.stream().sorted((o1, o2) -> o1.get(index).compareTo(o2.get(index))).collect(Collectors.toList());
            System.out.println(String.join(" | ", header));
            printData(sorted);

        } else if (commands[0].equals("filter")) {
            List<List<String>> filteredData = data.stream().filter(strings -> strings.get(index).equals(commands[2])).collect(Collectors.toList());
            System.out.println(String.join(" | ", header));
            printData(filteredData);

        } else if (commands[0].equals("hide")) {
            String[] newHeaders = Arrays.stream(header).filter(h -> !h.equals(commands[1])).toArray(String[]::new);

            System.out.println(String.join(" | ", newHeaders));

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < data.size(); i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < data.get(i).size(); j++) {
                    if (j == index) {
                        continue;
                    }
                    stringBuilder.append(data.get(i).get(j)).append(" | ");
                }
                output.append(stringBuilder.substring(0, stringBuilder.length() - 2)).append("\n");
            }
            System.out.println(output.toString());
        }

    }

    private static void printData(List<List<String>> data) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < data.get(i).size(); j++) {
                stringBuilder.append(data.get(i).get(j)).append(" | ");
            }

            output.append(stringBuilder.substring(0, stringBuilder.length() - 2)).append("\n");
        }
        System.out.println(output.toString());
    }
}
