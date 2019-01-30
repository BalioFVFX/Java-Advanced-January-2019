import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfLogs = Integer.parseInt(bufferedReader.readLine());

        TreeMap<String, TreeMap<String, Long>> users = new TreeMap<>();

        for (int i = 0; i < numberOfLogs; i++) {
            String[] line = bufferedReader.readLine().split("\\s+");
            String ip = line[0];
            String name = line[1];
            Long duration = Long.parseLong(line[2]);

            TreeMap<String, Long> logs = new TreeMap<>();
            if (users.containsKey(name)) {
                logs = new TreeMap<>(users.get(name));
            }

            if (!logs.containsKey(ip)) {
                logs.put(ip, duration);
            } else {
                logs.put(ip, logs.get(ip) + duration);
            }
            users.put(name, logs);
        }

        for (String name : users.keySet()) {
            System.out.println(String.format("%s: %s [%s]",
                    name,
                    users.get(name).values().stream().mapToLong(duration -> duration).sum(),
                    String.join(", ", users.get(name).keySet().toArray(new String[0]))));
        }
    }
}
