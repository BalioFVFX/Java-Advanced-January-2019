import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private static final String COMMAND_END = "end";
    private static final String COMMAND_ADD = "add";
    private static final String COMMAND_PRINT = "print";
    private static final String COMMAND_SUBTRACT = "subtract";
    private static final String COMMAND_MULTIPLY = "multiply";
    private static final Consumer<Long> printer = number -> System.out.printf("%s ", number);
    private static final Function<Long, Long> add = number -> number + 1;
    private static final Function<Long, Long> subtract = number -> number - 1;
    private static final Function<Long, Long> multiply = number -> number * 2;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> numbers = Arrays.stream(bufferedReader.readLine().split("\\s+")).map(Long::parseLong).collect(Collectors.toList());

        String command = bufferedReader.readLine();

        while (!command.equals(COMMAND_END)) {

            switch (command) {
                case COMMAND_ADD:
                    numbers = numbers.stream().map(add).collect(Collectors.toList());
                    break;
                case COMMAND_MULTIPLY:
                    numbers = numbers.stream().map(multiply).collect(Collectors.toList());
                    break;
                case COMMAND_SUBTRACT:
                    numbers = numbers.stream().map(subtract).collect(Collectors.toList());
                    break;
                case COMMAND_PRINT:
                    System.out.println();
                    numbers.forEach(printer);
                    break;
                default:
                    break;
            }
            command = bufferedReader.readLine();
        }

    }
}
