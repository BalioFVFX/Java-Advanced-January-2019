import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> phoneBook = new HashMap<>();
        String line = bufferedReader.readLine();

        while (!line.equals("search")) {
            String[] contactDetails = line.split("-");
            String name = contactDetails[0];
            String number = contactDetails[1];

            phoneBook.put(name, number);

            line = bufferedReader.readLine();
        }

        String name = bufferedReader.readLine();

        while (!name.equals("stop")) {
            if (!phoneBook.containsKey(name)) {
                System.out.println(String.format("Contact %s does not exist.", name));
            } else {
                System.out.println(String.format("%s -> %s", name, phoneBook.get(name)));
            }
            name = bufferedReader.readLine();
        }
    }
}
