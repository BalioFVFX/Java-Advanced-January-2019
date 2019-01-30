import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        String line = bufferedReader.readLine();

        String previousResource = null;
        for (int i = 0; !line.equals("stop"); i++) {

            if (i % 2 == 0) {
                if (!resources.containsKey(line)) {
                    resources.put(line, 0);
                }
            } else {
                resources.put(previousResource, resources.get(previousResource) + Integer.parseInt(line));
            }

            previousResource = line;
            line = bufferedReader.readLine();
        }

        for (String resource : resources.keySet()) {
            Integer quantity = resources.get(resource);
            System.out.println(String.format("%s -> %s", resource, quantity));
        }
    }
}
