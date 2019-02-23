import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String NAME_REGEX = "[A-Z][a-z]+ [A-Z][a-z]+";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int problemsCount = Integer.parseInt(bufferedReader.readLine());
        int candidatesCount = Integer.parseInt(bufferedReader.readLine());

        ArrayDeque<String> problemStack = new ArrayDeque<>();
        ArrayDeque<String> candidatesQueue = new ArrayDeque<>();


        for (int i = 0; i < problemsCount; i++) {
            problemStack.push(bufferedReader.readLine());
        }


        Pattern pattern = Pattern.compile(NAME_REGEX);
        for (int i = 0; i < candidatesCount; i++) {
            String candidateName = bufferedReader.readLine();
            Matcher matcher = pattern.matcher(candidateName);
            if (matcher.matches()) {
                candidatesQueue.offer(candidateName);
            }
        }

        while (!problemStack.isEmpty()) {
            String problemName = problemStack.pop();
            String candidateName = candidatesQueue.poll();

            int problemSum = getSum(problemName);
            int candidateSum = getSum(candidateName);

            if (candidateSum > problemSum) {
                System.out.printf("%s solved %s.%n", candidateName, problemName);
                candidatesQueue.offer(candidateName);
            } else {
                System.out.printf("%s failed %s.%n", candidateName, problemName);
                problemStack.addLast(problemName);
            }

            if (candidatesQueue.size() == 1) {
                System.out.printf("%s gets the job!", candidatesQueue.poll());
                return;
            }
        }

        System.out.println(String.join(", ", candidatesQueue));
    }

    private static int getSum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i);
        }
        return sum;
    }
}
