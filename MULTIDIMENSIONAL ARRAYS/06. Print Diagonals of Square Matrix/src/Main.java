import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrix[][] = createMatrix(scanner);

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }

        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[matrix.length - 1 - i][i] + " ");
        }

    }

    private static int[][] createMatrix(Scanner scanner){

        int rowsCols = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rowsCols][rowsCols];

        for (int i = 0; i < rowsCols; i++) {

            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[i] = currentRow;
        }
        return matrix;
    }
}
