import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(", ");
        int matrixSize = Integer.parseInt(input[0]);
        char matrixType = input[1].charAt(0);
        int[][] matrix = createMatrix(matrixSize, matrixType);

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] createMatrix(int size, char type) {
        int[][] matrix = new int[size][size];

        int sum = 1;
        switch (type) {
            case 'A':
                for (int col = 0; col < size; col++) {
                    for (int row = 0; row < size; row++) {
                        matrix[row][col] = sum;
                        sum++;
                    }
                }
                return matrix;
            case 'B':
                for (int col = 0; col < size; col++) {
                    if (col % 2 == 0) {
                        for (int row = 0; row < size; row++) {
                            matrix[row][col] = sum;
                            sum++;
                        }
                    } else {
                        for (int row = size - 1; row >= 0; row--) {
                            matrix[row][col] = sum;
                            sum++;
                        }
                    }
                }

                return matrix;
            default:
                return null;
        }
    }
}
