import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        long factorial = factorial(number);
        System.out.println(factorial);
    }

    private static long factorial(int number){
        if(number == 1){
            return 1;
        }

        return number * factorial(number - 1);
    }
}
