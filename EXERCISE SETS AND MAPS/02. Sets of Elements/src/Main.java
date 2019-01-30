import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("\\s+");

        int firstSetLength = Integer.parseInt(input[0]);
        int secondSetLength = Integer.parseInt(input[1]);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetLength; i++) {
            firstSet.add(Integer.parseInt(bufferedReader.readLine()));
        }

        for (int i = 0; i < secondSetLength; i++) {
            secondSet.add(Integer.parseInt(bufferedReader.readLine()));
        }

        StringBuilder output = new StringBuilder();


        if (firstSetLength >= secondSetLength) {
            for (int number : firstSet) {
                if (secondSet.contains(number)) {
                    output.append(number).append(" ");
                }
            }
        } else {
            for (int number : secondSet) {
                if (firstSet.contains(number)) {
                    output.append(number).append(" ");
                }
            }
        }
        System.out.println(output.toString().trim());
    }
}
