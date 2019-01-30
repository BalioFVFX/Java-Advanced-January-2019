import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();

        while (true) {
            String[] input = bufferedReader.readLine().split("\\|+");
            if (input[0].equals("report")) {
                break;
            }
            String country = input[1];
            String city = input[0];
            Long population = Long.parseLong(input[2]);

            LinkedHashMap<String, Long> cities = new LinkedHashMap<>();
            if (countries.containsKey(country)) {
                cities = new LinkedHashMap<>(countries.get(country));
            }

            if (!cities.containsKey(city)) {
                cities.put(city, population);
            } else {
                cities.put(city, cities.get(city) + population);
            }

            countries.put(country, cities);
        }

        Map<String, Map<String, Long>> sortedCountries = countries.entrySet().stream().sorted((o1, o2) -> {
            Long population1 = o1.getValue().values().stream().mapToLong(p -> p).sum();
            Long population2 = o2.getValue().values().stream().mapToLong(p -> p).sum();
            return population2.compareTo(population1);


        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new));

        for (String country : sortedCountries.keySet()) {
            Long totalCountryPopulation = sortedCountries.get(country).entrySet().stream().mapToLong(Map.Entry::getValue).sum();
            LinkedHashMap<String, Long> sortedCities = sortedCountries.get(country).entrySet().stream().sorted((o1, o2) -> {
                Long cityPopulation1 = o1.getValue();
                Long cityPopulation2 = o2.getValue();
                return cityPopulation2.compareTo(cityPopulation1);
            }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            System.out.println(String.format("%s (total population: %s)", country, totalCountryPopulation));
            for (String city : sortedCities.keySet()) {
                System.out.println(String.format("=>%s: %s", city, sortedCities.get(city)));
            }
            ;
        }
    }
}
