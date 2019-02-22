import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] sizes = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[sizes[0]][sizes[1]];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = bufferedReader.readLine().split("\\s+");
        }

        String newSymbol = bufferedReader.readLine();
        int[] startPositions = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        solve(startPositions[0], startPositions[1], matrix, newSymbol, matrix[startPositions[0]][startPositions[1]]);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void solve(int row, int col, String[][] matrix, String newSymbol, String oldSymbol) {
        if (!isValid(row, col, matrix, newSymbol, oldSymbol)) {
            return;
        }

        matrix[row][col] = newSymbol;
        solve(row + 1, col, matrix, newSymbol, oldSymbol);
        solve(row - 1, col, matrix, newSymbol, oldSymbol);
        solve(row, col - 1, matrix, newSymbol, oldSymbol);
        solve(row, col + 1, matrix, newSymbol, oldSymbol);
    }


    private static boolean isValid(int row, int col, String[][] matrix, String symbol, String oldSymbol) {
        if (row < 0 || row > matrix.length - 1) {
            return false;
        }

        if (col < 0 || col > matrix[0].length - 1) {
            return false;
        }

        if (matrix[row][col].equals(symbol)) {
            return false;
        }

        if (!matrix[row][col].equals(oldSymbol)) {
            return false;
        }
        return true;
    }
}
