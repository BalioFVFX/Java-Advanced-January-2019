import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Main {
    private static boolean isObtained = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Long> materials = new TreeMap<>();
        TreeMap<String, Long> junkItems = new TreeMap<>();
        materials.put("motes", 0L);
        materials.put("fragments", 0L);
        materials.put("shards", 0L);
        while (!isObtained) {
            String[] input = bufferedReader.readLine().split(" |\\n");
            for (int i = 0; i < input.length; i += 2) {
                Long currentQuantity = Long.parseLong(input[i]);
                String currentMaterial = input[i + 1].toLowerCase();

                if (currentMaterial.equals("shards") || currentMaterial.equals("fragments") || currentMaterial.equals("motes")) {
                    if (!materials.containsKey(currentMaterial)) {
                        materials.put(currentMaterial, currentQuantity);
                    } else {
                        materials.put(currentMaterial, materials.get(currentMaterial) + currentQuantity);
                    }

                    if (materials.get(currentMaterial) >= 250) {
                        materials.put(currentMaterial, materials.get(currentMaterial) - 250);
                        System.out.println(String.format("%s obtained!", getObtainedItem(currentMaterial)));

                        materials.entrySet().stream().sorted((o1, o2) -> {
                            Long material1Count = o1.getValue();
                            Long material2Count = o2.getValue();
                            return material2Count.compareTo(material1Count);
                        }).forEach(sortedMaterial -> {
                            System.out.println(String.format("%s: %s", sortedMaterial.getKey(), sortedMaterial.getValue()));
                        });
                        junkItems.forEach((key1, value1) -> System.out.println(String.format("%s: %s", key1, value1)));
                        isObtained = true;
                        break;
                    }
                } else {
                    if (!junkItems.containsKey(currentMaterial)) {
                        junkItems.put(currentMaterial, currentQuantity);
                    } else {
                        junkItems.put(currentMaterial, junkItems.get(currentMaterial) + currentQuantity);
                    }
                }
            }
        }


    }

    private static String getObtainedItem(String material) {
        switch (material) {
            case "shards":
                return "Shadowmourne";
            case "fragments":
                return "Valanyr";
            case "motes":
                return "Dragonwrath";
            default:
                return null;
        }
    }
}