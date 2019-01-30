import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        int numberOfUsers = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < numberOfUsers; i++) {
            usernames.add(bufferedReader.readLine());
        }

        for (String name : usernames) {
            System.out.println(name);
        }
    }
}
