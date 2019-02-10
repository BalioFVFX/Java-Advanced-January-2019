import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Person> people;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> inputData = new ArrayList<>();
        people = new ArrayList<>();

        String mainCharacter = bufferedReader.readLine();

        String data = bufferedReader.readLine();

        while (!data.equals("End")) {
            if (data.contains("-")) {
                inputData.add(data);
            } else {
                String[] lines = data.split("\\s+");
                String firstName = lines[0];
                String lastName = lines[1];
                String birthDate = lines[2];
                Person person = new Person(firstName, lastName, birthDate);
                people.add(person);
            }

            data = bufferedReader.readLine();
        }

        System.out.println();
        Person person = null;

        if (mainCharacter.contains("/")) {
            person = people.stream().filter(p -> p.birthDate.equals(mainCharacter)).findFirst().orElse(null);
        } else {
            person = people.stream().filter(p -> p.getFullName().equals(mainCharacter)).findFirst().orElse(null);
        }

        for (String personDataInput : inputData) {
            String[] lines = personDataInput.split(" - ");
            Person personA = getPersonByToken(lines[0]);
            Person personB = getPersonByToken(lines[1]);
            if (!containsMainCharacter(personA, personB, person)) {
                continue;
            }

            if (person.getFullName().equals(personA.getFullName())) {
                person.children.add(personB);
            } else {
                person.parents.add(personA);
            }
        }
        System.out.println(person);
        System.out.println("Parents:");
        person.parents.forEach(System.out::println);
        System.out.println("Children:");
        person.children.forEach(System.out::println);
    }

    private static boolean containsMainCharacter(Person personA, Person personB, Person originalPerson) {
        if (originalPerson.getFullName().equals(personA.getFullName())) {
            return true;
        }
        if (originalPerson.getFullName().equals(personB.getFullName())) {
            return true;
        }
        return false;
    }

    private static Person getPersonByToken(String token) {
        if (token.contains("/")) {
            return people.stream().filter(p -> p.birthDate.equals(token)).findFirst().orElse(null);
        } else {
            return people.stream().filter(p -> p.getFullName().equals(token)).findFirst().orElse(null);
        }
    }
}
