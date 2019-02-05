import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPeople = Integer.parseInt(bufferedReader.readLine());

        IntStream.rangeClosed(1, numberOfPeople)
                .boxed()
                .map(input -> {
                    try {
                        return bufferedReader.readLine().split("\\s+");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .map(input -> new Person(input[0], Integer.parseInt(input[1])))
                .filter(peron -> peron.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(person -> System.out.printf("%s - %d%n", person.getName(), person.getAge()));

    }
}
