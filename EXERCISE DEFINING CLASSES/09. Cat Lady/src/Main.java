import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Set<Cat> cats = new HashSet<>();

        String input = bufferedReader.readLine();

        while (!input.equals("End")){
            String[] lines = input.split("\\s+");

            switch (lines[0]){
                case "Siamese":
                    cats.add(new Siamese(lines[1], Double.parseDouble(lines[2])));
                    break;
                case "Cymric":
                    cats.add(new Cymric(lines[1], Double.parseDouble(lines[2])));
                    break;
                case "StreetExtraordinaire":
                    cats.add(new StreetExtraordinaire(lines[1], Double.parseDouble(lines[2])));
                    break;
                    default:
                        break;
            }
            input = bufferedReader.readLine();
        }
        String catName = bufferedReader.readLine();
        cats.forEach(cat -> {
            if(cat.getName().equals(catName)){
                try {
                    System.out.printf("Cymric %s %.2f", catName, ((Cymric) cat).getFurLength());
                }catch (ClassCastException e){
                    try {
                        System.out.printf("Siamese %s %.2f", catName, ((Siamese) cat).getEarSize());
                    }catch (ClassCastException e2){
                        try {
                            System.out.printf("StreetExtraordinaire %s %.2f", catName, ((StreetExtraordinaire) cat).getDecibelsOfMeows());
                        }catch (ClassCastException e3){
                            System.out.println("Invalid breed");
                        }
                    }
                }
                return;
            }
        });
    }
}
