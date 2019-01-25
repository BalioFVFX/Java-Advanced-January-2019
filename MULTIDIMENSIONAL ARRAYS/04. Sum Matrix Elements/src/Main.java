import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = createMatrix(scanner);

        int sum = 0;

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }

        System.out.println(sum);
    }

    private static int[][] createMatrix(Scanner scanner){

        String[] input = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);


        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            int[] currentRow = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

            matrix[i] = currentRow;
        }
        return matrix;
    }
}
