import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    private final static String REGEX_PATTERN = "[a-zA-Z ]+ @[A-Za-z ]+ [0-9]+ [0-9]+";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = bufferedReader.readLine();

        final Pattern pattern = Pattern.compile(REGEX_PATTERN, Pattern.MULTILINE);

        LinkedHashMap<String, LinkedHashMap<String, Long>> locations = new LinkedHashMap<>();

        while (!line.equals("End")) {
            final Matcher matcher = pattern.matcher(line);
            if (!matcher.matches()) {
                line = bufferedReader.readLine();
                continue;
            }

            String singer = line.substring(0, line.indexOf("@") - 1);
            String location = line.substring(line.indexOf("@") + 1, getDigitPosition(line) - 1);
            Long ticketsPrice = Long.parseLong(line.substring(getDigitPosition(line), line.lastIndexOf(" ")));
            Long ticketsCount = Long.parseLong(line.substring(line.lastIndexOf(" ") + 1, line.length()));


            if (!locations.containsKey(location)) {
                LinkedHashMap<String, Long> singers = new LinkedHashMap<>();
                singers.put(singer, ticketsPrice * ticketsCount);
                locations.put(location, singers);
            } else {
                LinkedHashMap<String, Long> singers = locations.get(location);

                if (!singers.containsKey(singer)) {
                    singers.put(singer, ticketsCount * ticketsPrice);
                } else {
                    singers.put(singer, singers.get(singer) + (ticketsCount * ticketsPrice));
                }
                locations.put(location, singers);
            }

            line = bufferedReader.readLine();
        }

        for (String location : locations.keySet()) {
            System.out.println(location);
            LinkedHashMap<String, Long> singers = locations.get(location).entrySet().stream().sorted((o1, o2) -> {
                Long cityPopulation1 = o1.getValue();
                Long cityPopulation2 = o2.getValue();
                return cityPopulation2.compareTo(cityPopulation1);
            }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            for (String singer : singers.keySet()) {
                System.out.println(String.format("#  %s -> %s",
                        singer, singers.get(singer)));
            }
        }
    }

    private static int getDigitPosition(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                return i;
            }
        }
        return 0;
    }

}
