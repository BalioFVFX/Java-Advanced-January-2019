import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashMap<String, Long>> players = new LinkedHashMap<>();

        while (true) {
            String line = bufferedReader.readLine();

            if (line.equals("JOKER")) {
                break;
            }

            String name = line.split(":")[0];
            String[] cardsInput = Arrays.stream(line.split(": |, ")).filter(s -> !s.equals(name)).toArray(String[]::new);

            LinkedHashMap<String, Long> cards = new LinkedHashMap<>();

            if (players.containsKey(name)) {
                cards = new LinkedHashMap<>(players.get(name));
            }

            for (int i = 0; i < cardsInput.length; i++) {
                String card = cardsInput[i];
                long points = calculatePower(card);
                if (!cards.containsKey(card)) {
                    cards.put(card, points);
                }
            }

            players.put(name, cards);
        }

        for (String name : players.keySet()) {
            LinkedHashMap<String, Long> cards = players.get(name);
            long points = cards.values().stream().mapToLong(s -> s).sum();
            System.out.println(name.trim() + ": " + points);
        }

    }

    private static long calculatePower(String card) {
        long points = 0;
        String type = null;
        if (card.length() == 3) {
            points = Integer.parseInt(card.substring(0, 2));
            type = card.substring(2, 3);
        } else {
            try {
                points = Integer.parseInt(card.substring(0, 1));
            } catch (NumberFormatException e) {
                String power = card.substring(0, 1);
                switch (power) {
                    case "J":
                        points = 11;
                        break;
                    case "Q":
                        points = 12;
                        break;
                    case "K":
                        points = 13;
                        break;
                    case "A":
                        points = 14;
                        break;
                    default:
                        break;
                }
            }
            type = card.substring(1, 2);
        }

        switch (type) {
            case "S":
                return points * 4;
            case "H":
                return points * 3;
            case "D":
                return points * 2;
            case "C":
                return points;
            default:
                return points;
        }

    }
}
