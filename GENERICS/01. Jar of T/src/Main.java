import jar.Jar;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> numbers = new Jar<>();

        for (int i = 1; i <= 5; i++) {
            numbers.add(i);
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println(numbers.remove());
        }
    }
}
