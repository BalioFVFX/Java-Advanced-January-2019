import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> invites = new HashSet<>();
        String line = bufferedReader.readLine();

        while (!line.equals("PARTY")) {
            invites.add(line);
            line = bufferedReader.readLine();
        }

        Set<String> guests = new HashSet<>();

        line = bufferedReader.readLine();
        while (!line.equals("END")) {
            guests.add(line);
            line = bufferedReader.readLine();
        }

        Set<String> declinedInvites = new TreeSet<>();
        for (String invite : invites) {
            if (!guests.contains(invite)) {
                declinedInvites.add(invite);
            }
        }

        System.out.println(declinedInvites.size());
        for (String declines : declinedInvites) {
            System.out.println(declines);
        }

    }
}
