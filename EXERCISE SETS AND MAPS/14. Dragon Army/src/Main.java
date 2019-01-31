import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, TreeMap<String, Dragon>> types = new LinkedHashMap<>();


        Long numberOfDragons = Long.parseLong(bufferedReader.readLine());

        for (int i = 0; i < numberOfDragons; i++) {
            String[] line = bufferedReader.readLine().split("\\s+");
            String type = line[0];
            String dragonName = line[1];
            Long damage = null;
            Long health = null;
            Long armor = null;
            if (!line[2].equals("null")) {
                damage = Long.parseLong(line[2]);
            }
            if (!line[3].equals("null")) {
                health = Long.parseLong(line[3]);
            }
            if (!line[4].equals("null")) {
                armor = Long.parseLong(line[4]);
            }

            if (!types.containsKey(type)) {
                TreeMap<String, Dragon> dragons = new TreeMap<>();
                Dragon dragon = new Dragon(dragonName, damage, health, armor);
                dragons.put(dragonName, dragon);
                types.put(type, dragons);
            } else {
                TreeMap<String, Dragon> dragons = types.get(type);
                dragons.put(dragonName, new Dragon(dragonName, damage, health, armor));
                types.put(type, dragons);
            }
        }

        for (String type : types.keySet()) {
            TreeMap<String, Dragon> dragons = types.get(type);
            Double damageAverage = dragons.entrySet().stream().mapToDouble(dragon -> dragon.getValue().getDamage()).average().orElse(0);
            Double healthAverage = dragons.entrySet().stream().mapToDouble(dragon -> dragon.getValue().getHealth()).average().orElse(0);
            Double armorAverage = dragons.entrySet().stream().mapToDouble(dragon -> dragon.getValue().getArmor()).average().orElse(0);
            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)",
                    type,
                    damageAverage,
                    healthAverage,
                    armorAverage));

            for (String dragonName : dragons.keySet()) {
                System.out.println(String.format("-%s -> damage: %s, health: %s, armor: %s",
                        dragonName,
                        dragons.get(dragonName).damage,
                        dragons.get(dragonName).health,
                        dragons.get(dragonName).armor));
            }
        }
    }

    private static class Dragon {

        private String name;
        private Long health;
        private Long damage;
        private Long armor;


        public Dragon(String name, Long damage, Long health, Long armor) {
            this.name = name;
            setHealth(health);
            setDamage(damage);
            setArmor(armor);
        }

        public long getHealth() {
            return health;
        }

        public void setHealth(Long health) {
            if (health == null) {
                this.health = 250L;
            } else {
                this.health = health;
            }
        }

        public long getDamage() {
            return damage;
        }

        public void setDamage(Long damage) {
            if (damage == null) {
                this.damage = 45L;
            } else {
                this.damage = damage;
            }
        }

        public long getArmor() {
            return armor;
        }

        public void setArmor(Long armor) {
            if (armor == null) {
                this.armor = 10L;
            } else {
                this.armor = armor;
            }
        }
    }
}
