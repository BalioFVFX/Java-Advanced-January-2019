import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> chemicalCompounds = new TreeSet<>();

        int count = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < count; i++) {
            String[] compounds = bufferedReader.readLine().split(" ");
            chemicalCompounds.addAll(Arrays.asList(compounds));
        }

        StringBuilder output = new StringBuilder();
        for (String chemicalCompound : chemicalCompounds) {
            output.append(chemicalCompound).append(" ");
        }
        System.out.println(output.toString().trim());
    }
}
