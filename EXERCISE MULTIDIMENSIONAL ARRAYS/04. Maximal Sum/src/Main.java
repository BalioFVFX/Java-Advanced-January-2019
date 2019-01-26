import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = createMatrix(bufferedReader);

        int maxSum = Integer.MIN_VALUE;

        int row = 0;
        int col = 0;

        int prevRow = 0;
        int prevCol = 0;

        int[][] bestMatrix = new int[3][3];

        while (true) {
            int[][] currentBestMatrix = new int[3][3];
            int currentSum = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    currentSum += matrix[row][col];
                    currentBestMatrix[i][j] = matrix[row][col];
                    col++;
                }
                row++;
                col = prevCol;
            }

            if(currentSum > maxSum){
                maxSum = currentSum;
                bestMatrix = Arrays.copyOf(currentBestMatrix, 3);
            }

            row = prevRow;
            col = prevCol;


            if(col + 3 > matrix[0].length - 1){
                row++;
                col = 0;
            }
            else{
                col++;
            }

            if(row + 2 > matrix.length - 1){
                break;
            }
            prevRow = row;
            prevCol = col;
        }
        System.out.println("Sum = " + maxSum);

        for (int i = 0; i < bestMatrix.length; i++) {
            for (int j = 0; j < bestMatrix[i].length; j++) {
                System.out.print(bestMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }


    private static int[][] createMatrix(BufferedReader bufferedReader) throws IOException {

        String[] input = bufferedReader.readLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);


        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            int[] currentRow = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[i] = currentRow;
        }
        return matrix;
    }
}
