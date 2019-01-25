import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrix(scanner);

        int[] position = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int searchedNumber = matrix[position[0]][position[1]];

        int[][] resultMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != searchedNumber){
                    resultMatrix[i][j] = matrix[i][j];
                }
                else{
                    resultMatrix[i][j] = getSum(matrix, i, j, searchedNumber);
                }
            }
        }

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getSum(int[][] matrix, int currentRow, int currentCol, int searchedNumber){
        return getLeftNumber(matrix, currentRow, currentCol, searchedNumber) +
                getUpperNumber(matrix, currentRow, currentCol,  searchedNumber) +
                getRightNumber(matrix, currentRow, currentCol, searchedNumber) +
                getBottomNumber(matrix, currentRow, currentCol, searchedNumber);
    }

    private static int getLeftNumber(int[][] matrix, int currentRow, int currentCol, int searchedNumber){
        if(currentCol == 0 || matrix[currentRow][currentCol - 1] == searchedNumber){
            return 0;
        }

        return matrix[currentRow][currentCol - 1];
    }

    private static int getUpperNumber(int[][] matrix, int currentRow, int currentCol, int searchedNumber){
        if(currentRow == 0 || matrix[currentRow - 1][currentCol] == searchedNumber){
            return 0;
        }
        return matrix[currentRow - 1][currentCol];
    }

    private static int getRightNumber(int[][] matrix, int currentRow, int currentCol, int searchedNumber){
        if(currentCol == matrix[0].length - 1 || matrix[currentRow][currentCol + 1] == searchedNumber){
            return 0;
        }
        return matrix[currentRow][currentCol + 1];
    }

    private static int getBottomNumber(int[][] matrix, int currentRow, int currentCol, int searchedNumber){
        if(currentRow == matrix.length - 1 || matrix[currentRow + 1][currentCol] == searchedNumber){
            return 0;
        }
        return matrix[currentRow + 1][currentCol];
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
