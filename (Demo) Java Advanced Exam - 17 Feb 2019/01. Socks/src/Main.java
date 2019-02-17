import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> leftSocks = Arrays.stream(bufferedReader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> rightSocks = Arrays.stream(bufferedReader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> pairs = new ArrayList<>();


        int leftSockIndex = leftSocks.size() - 1;
        int rightSockIndex = 0;
        while (true) {

            int leftSock = 0;
            int rightSock = 0;
            try {
                leftSock = leftSocks.get(leftSockIndex);
                rightSock = rightSocks.get(rightSockIndex);
            } catch (IndexOutOfBoundsException e) {
                break;
            }


            if (leftSock == rightSock) {
                rightSocks.remove(rightSockIndex);
                leftSocks.set(leftSockIndex, leftSock + 1);
                continue;
            }

            if (rightSock > leftSock) {
                leftSocks.remove(leftSockIndex);
                leftSockIndex--;
            }

            if (leftSock > rightSock) {
                int pair = leftSock + rightSock;
                pairs.add(pair);
                leftSockIndex--;
                rightSockIndex++;
                continue;
            }

        }
        System.out.println(pairs.stream().max(Integer::compareTo).orElse(0));
        pairs.forEach(p -> System.out.printf("%s ", p));
    }
}
