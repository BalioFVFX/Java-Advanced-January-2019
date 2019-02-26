package heroRepository;

import java.util.ArrayList;
import java.util.List;

public class HeroRepository {
    private List<Hero> data;

    public HeroRepository(){
        this.data = new ArrayList<>();
    }

    public void add(Hero hero){
        this.data.add(hero);
    }

    public void remove(String name){
        Hero searched = this.data.stream().filter(h -> h.getName().equals(name)).findFirst().orElse(null);

        if(searched == null){
            return;
        }

        this.data.remove(searched);
    }

    public Hero getHeroWithHighestAgility(){
        return this.data.stream().sorted((h1, h2) -> Integer.compare(h2.getItem().getAgility(), h1.getItem().getAgility())).findFirst().orElse(null);

    }

    public Hero getHeroWithHighestIntelligence(){
        return this.data.stream().sorted((h1, h2) -> Integer.compare(h2.getItem().getIntelligence(), h1.getItem().getIntelligence())).findFirst().orElse(null);
    }

    public Hero getHeroWithHighestStrength(){
        return this.data.stream().sorted((h1, h2) -> Integer.compare(h2.getItem().getStrength(), h1.getItem().getStrength())).findFirst().orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Hero hero: data) {
            stringBuilder.append(hero);
        }
        return stringBuilder.toString();
    }
}
