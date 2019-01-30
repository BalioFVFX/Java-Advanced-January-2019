import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        while (true) {
            String[] input = bufferedReader.readLine().split("\\s+");
            if (input[0].equals("end")) {
                break;
            }

            String ip = input[0].split("=")[1];
            String user = input[2].split("=")[1];
            LinkedHashMap<String, Integer> logs = new LinkedHashMap<>();

            if (users.containsKey(user)) {
                logs = new LinkedHashMap<>(users.get(user));
            }

            if (!logs.containsKey(ip)) {
                logs.put(ip, 1);
            } else {
                logs.put(ip, logs.get(ip) + 1);
            }
            users.put(user, logs);
        }

        for (String user : users.keySet()) {
            StringBuilder output = new StringBuilder();
            output.append(user).append(": ").append("\n");
            LinkedHashMap<String, Integer> logs = users.get(user);
            for (String ip : logs.keySet()) {
                output.append(String.format("%s => %s, ", ip, logs.get(ip)));
            }
            output.replace(output.length() - 2, output.length(), ".");
            System.out.println(output.toString());
        }
    }
}
