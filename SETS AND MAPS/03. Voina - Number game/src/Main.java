import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class Main {
    private final static String FIRST_WIN = "First player win!";
    private final static String SECOND_WIN = "Second player win!";
    private final static String DRAW = "Draw!";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashSet<Integer> firstPlayerDeck = new LinkedHashSet<>(Arrays.stream(bufferedReader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));
        LinkedHashSet<Integer> secondPlayerDeck = new LinkedHashSet<>(Arrays.stream(bufferedReader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));

        for (int i = 0; i < 50; i++) {
            if (firstPlayerDeck.isEmpty()) {
                System.out.println(SECOND_WIN);
                return;
            }
            if (secondPlayerDeck.isEmpty()) {
                System.out.println(FIRST_WIN);
            }

            int firstPlayerCard = firstPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstPlayerCard);

            int secondPlayerCard = secondPlayerDeck.iterator().next();
            secondPlayerDeck.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);

            } else {
                firstPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }
        }

        if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println(FIRST_WIN);
        } else if (secondPlayerDeck.size() > firstPlayerDeck.size()) {
            System.out.println(SECOND_WIN);
        } else {
            System.out.println(DRAW);
        }
    }
}
