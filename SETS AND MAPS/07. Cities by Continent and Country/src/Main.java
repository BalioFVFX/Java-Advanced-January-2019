import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continents = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!continents.containsKey(continent)) {
                LinkedHashMap<String, ArrayList<String>> countries = new LinkedHashMap<>();
                ArrayList<String> cities = new ArrayList<>();

                cities.add(city);
                countries.put(country, cities);
                continents.put(continent, countries);
            } else {
                LinkedHashMap<String, ArrayList<String>> countries = continents.get(continent);

                if (!countries.containsKey(country)) {
                    ArrayList<String> cities = new ArrayList<>();
                    cities.add(city);
                    countries.put(country, cities);
                } else {
                    ArrayList<String> cities = countries.get(country);
                    cities.add(city);
                    countries.put(country, cities);
                }

                continents.put(continent, countries);
            }
        }

        for (String continent : continents.keySet()) {
            System.out.println(String.format("%s:", continent));
            LinkedHashMap<String, ArrayList<String>> countries = continents.get(continent);

            for (String country : countries.keySet()) {
                ArrayList<String> cities = countries.get(country);
                System.out.println(String.format("  %s -> %s", country, String.join(", ", cities)));
            }
        }
    }
}
