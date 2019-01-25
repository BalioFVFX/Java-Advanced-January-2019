import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = createMatrix(scanner);

        int[] bestSum = new int[] {0};
        for (int i = 0; i <matrix.length - 1 ; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int[] currentBestSum = getBestSum(matrix, i, j);
                if(currentBestSum[0] > bestSum[0]){
                    bestSum = currentBestSum;
                }
            }
        }
        System.out.println(bestSum[1] + " " + bestSum[2]);
        System.out.println(bestSum[3] + " " + bestSum[4]);
        System.out.println(bestSum[0]);
    }

    private static int[] getBestSum(int[][] matrix, int row, int col){
        int firstRowA = matrix[row][col];
        int firstRowB = matrix[row][col + 1];
        int secondRowA = matrix[row + 1][col];
        int secondRowB = matrix[row + 1][col + 1];

        return new int[]{firstRowA + firstRowB + secondRowA + secondRowB,
        firstRowA,
        firstRowB,
        secondRowA,
        secondRowB};
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
