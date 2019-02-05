import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] lines = input.split("\\s+");

            String trainerName = lines[0];
            String pokemonName = lines[1];
            String pokemonElement = lines[2];
            int pokemonHealth = Integer.parseInt(lines[3]);

            if (!trainers.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName);
                trainer.getPokemons().add(new Pokemon(pokemonName, pokemonElement, pokemonHealth));
                trainers.put(trainerName, trainer);
            } else {
                Trainer trainer = trainers.get(trainerName);
                trainer.getPokemons().add(new Pokemon(pokemonName, pokemonElement, pokemonHealth));
                trainers.put(trainerName, trainer);
            }

            input = bufferedReader.readLine();
        }
        input = bufferedReader.readLine();

        while (!input.equals("End")) {
            for (String trainerName : trainers.keySet()) {
                Trainer trainer = trainers.get(trainerName);
                List<Pokemon> pokemons = trainer.getPokemons();
                boolean hasBadge = false;
                for (Pokemon pokemon : pokemons) {
                    if (pokemon.getElement().equals(input)) {
                        hasBadge = true;
                        break;
                    }
                }
                if (hasBadge) {
                    trainer.setBadges(trainer.getBadges() + 1);
                } else {
                    trainer.getPokemons().forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
                    trainer.setPokemons(trainer.getPokemons().stream().filter(pokemon -> pokemon.getHealth() > 0).collect(Collectors.toList()));
                }


            }
            input = bufferedReader.readLine();
        }

        trainers.values().stream().sorted((trainer1, trainer2) -> Integer.compare(trainer2.getBadges(), trainer1.getBadges())).forEach(trainer -> {
            System.out.printf("%s %s %s%n", trainer.getName(), trainer.getBadges(), trainer.getPokemons().size());
        });
    }
}
