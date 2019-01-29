import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<Double, Integer> occurrences = new LinkedHashMap<>();
        double[] numbersInput = Arrays.stream(bufferedReader.readLine().split("\\s")).mapToDouble(Double::parseDouble).toArray();

        for (int i = 0; i < numbersInput.length; i++) {
            double currentNumber = numbersInput[i];
            if(!occurrences.containsKey(currentNumber)){
                occurrences.put(currentNumber, 1);
            }else{
                occurrences.put(currentNumber, occurrences.get(currentNumber) + 1);
            }
        }

        for (Double key: occurrences.keySet()) {
            System.out.println(String.format("%.1f -> %d", key, occurrences.get(key)));
        }
    }
}
