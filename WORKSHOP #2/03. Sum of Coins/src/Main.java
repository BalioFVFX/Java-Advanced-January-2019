import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> coins = new TreeMap<>((c1, c2) -> Integer.compare(c2, c1));

        int[] coinsInput = Arrays.stream(bufferedReader.readLine().substring(7).split(", ")).mapToInt(Integer::parseInt).toArray();
        int finalSum = Integer.parseInt(bufferedReader.readLine().substring(5));

        Arrays.stream(coinsInput).forEach(coin -> {
            coins.put(coin, 0);
        });

        for (Integer coin : coins.keySet()) {
            int numberOfCoins = finalSum / coin;
            finalSum %= coin;
            coins.replace(coin, numberOfCoins);
        }
        if (finalSum != 0) {
            System.out.println("Error");
            return;
        }
        int numberOfCoinsToTake = coins.values().stream().mapToInt(c -> c).sum();
        System.out.printf("Number of coins to take: %s%n", numberOfCoinsToTake);
        coins.entrySet().stream().filter(entry -> entry.getValue() != 0).forEach(entry -> {
            System.out.printf("%s coin(s) with value %s%n", entry.getValue(), entry.getKey());
        });
    }
}

