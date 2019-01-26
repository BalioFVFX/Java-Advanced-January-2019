import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int matrixSize = Integer.parseInt(bufferedReader.readLine());

        int[][] matrix = createMatrix(bufferedReader, matrixSize);

        System.out.println(Math.max(getLeftToRightDownSum(matrix), getLeftToRightUpSum(matrix)) - Math.min(getLeftToRightDownSum(matrix), getLeftToRightUpSum(matrix)));

    }

    private static int getLeftToRightDownSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int getLeftToRightUpSum(int[][] matrix) {
        int sum = 0;
        int counter = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            sum += matrix[counter][i];
            counter++;
        }
        return sum;
    }


    private static int[][] createMatrix(BufferedReader bufferedReader, int size) throws IOException {

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {

            int[] currentRow = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[i] = currentRow;
        }
        return matrix;
    }
}
