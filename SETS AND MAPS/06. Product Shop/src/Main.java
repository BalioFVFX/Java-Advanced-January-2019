import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();

        String input = bufferedReader.readLine();

        while (!input.equals("Revision")){
            String[] currentData = input.split(", ");
            String shopName = currentData[0];
            String productName = currentData[1];
            Double productPrice = Double.parseDouble(currentData[2]);

            if(!shops.containsKey(shopName)){
                LinkedHashMap<String, Double> products = new LinkedHashMap<>();
                products.put(productName, productPrice);
                shops.put(shopName, products);

            }else{
                LinkedHashMap<String, Double> products = shops.get(shopName);

                products.put(productName, productPrice);

                shops.put(shopName, products);
            }

            input = bufferedReader.readLine();
        }

        for (String shopName: shops.keySet()){
            System.out.println(String.format("%s->", shopName));
            LinkedHashMap<String, Double> products = shops.get(shopName);
            for (String productName: products.keySet()){
                System.out.println(String.format("Product: %s, Price: %.1f", productName, products.get(productName)));
            }
        }
    }
}
