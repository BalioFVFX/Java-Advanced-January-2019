import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPlants = Integer.parseInt(bufferedReader.readLine());
        Integer[] plantsInput = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        ArrayDeque<Integer> previousPlantsIndexes = new ArrayDeque<>();
        int[] previousPlantDeathDay = new int[numberOfPlants];

        previousPlantsIndexes.push(0);

        for (int i = 1; i < numberOfPlants; i++) {
            int lastDay = 0;

            while (!previousPlantsIndexes.isEmpty() &&
                    plantsInput[previousPlantsIndexes.peek()] >= plantsInput[i]) {
                lastDay = Math.max(lastDay, previousPlantDeathDay[previousPlantsIndexes.pop()]);
            }

            if (previousPlantsIndexes.size() > 0) {
                previousPlantDeathDay[i] = lastDay + 1;
            }

            previousPlantsIndexes.push(i);

        }
        System.out.println(Arrays.stream(previousPlantDeathDay).max().orElse(0));
    }
}