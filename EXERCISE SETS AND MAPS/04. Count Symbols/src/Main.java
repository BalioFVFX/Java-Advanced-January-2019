import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Character, Integer> symbols = new TreeMap<>();
        String line = bufferedReader.readLine();
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);

            if (!symbols.containsKey(symbol)) {
                symbols.put(symbol, 1);
            } else {
                symbols.put(symbol, symbols.get(symbol) + 1);
            }
        }

        for (char symbol : symbols.keySet()) {
            int occurrences = symbols.get(symbol);
            System.out.println(String.format("%s: %s time/s", symbol, occurrences));
        }
    }
}
